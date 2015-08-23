package com.dkellycollins.triggerfinger;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.dkellycollins.triggerfinger.data.daos.ICollidableDao;
import com.dkellycollins.triggerfinger.data.daos.IPlayerDao;
import com.dkellycollins.triggerfinger.data.daos.ITouchPositionDao;
import com.dkellycollins.triggerfinger.data.daos.impl.CollidableDao;
import com.dkellycollins.triggerfinger.data.daos.impl.PlayerDao;
import com.dkellycollins.triggerfinger.data.daos.impl.TouchPositionDao;
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IPlayerEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.impl.CollidableEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.impl.PlayerEntityManager;
import com.dkellycollins.triggerfinger.managers.state.IStateManager;
import com.dkellycollins.triggerfinger.managers.state.impl.PlayerStateManager;
import com.dkellycollins.triggerfinger.managers.view.IViewManager;
import com.dkellycollins.triggerfinger.managers.view.impl.PlayerViewManager;
import com.dkellycollins.triggerfinger.util.logger.ILogWriter;
import com.dkellycollins.triggerfinger.util.logger.ILogger;
import com.dkellycollins.triggerfinger.util.logger.impl.Logger;
import com.dkellycollins.triggerfinger.util.logger.impl.SystemLogWriter;

import java.util.ArrayList;
import java.util.List;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private GameThread _gameThread;

    public GameView(Context context) {
        super(context);

        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        startThread();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        stopThread();
    }

    private void startThread() {
        if(_gameThread != null) {
            return;
        }

        //Util
        List<ILogWriter> logWriters = new ArrayList<>();
        logWriters.add(new SystemLogWriter());
        ILogger logger = new Logger(logWriters);

        //Data
        ITouchPositionDao touchPositionDao = new TouchPositionDao(this, logger);
        ICollidableDao collidableDao = new CollidableDao();
        IPlayerDao playerDao = new PlayerDao();

        //Entity managers.
        ICollidableEntityManager collidableEntityManager = new CollidableEntityManager(collidableDao);
        IPlayerEntityManager playerEntityManager = new PlayerEntityManager(playerDao, collidableEntityManager);

        //State managers.
        List<IStateManager> stateManagers = new ArrayList<IStateManager>();
        stateManagers.add(new PlayerStateManager(playerEntityManager, collidableEntityManager, touchPositionDao));

        //View managers.
        List<IViewManager> viewManagers = new ArrayList<IViewManager>();
        viewManagers.add(new PlayerViewManager(playerEntityManager, collidableEntityManager));

        _gameThread = new GameThread(this, stateManagers, viewManagers, logger);
        _gameThread.setActive(true);
        _gameThread.start();
    }

    private void stopThread() {
        if(_gameThread == null) {
            return;
        }

        _gameThread.setActive(false);

        boolean retry = true;
        while(retry) {
            try {
                _gameThread.join();
                retry = false;
            }
            catch (InterruptedException e) { }
        }
        _gameThread = null;
    }
}
