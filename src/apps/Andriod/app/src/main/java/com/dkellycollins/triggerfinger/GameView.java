package com.dkellycollins.triggerfinger;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.dkellycollins.triggerfinger.daos.ITouchPositionDao;
import com.dkellycollins.triggerfinger.daos.impl.EntityDao;
import com.dkellycollins.triggerfinger.daos.impl.TouchPositionDao;
import com.dkellycollins.triggerfinger.entity.ICollidable;
import com.dkellycollins.triggerfinger.entity.IPlayer;
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IPlayerEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.impl.CollidableEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.impl.PlayerEntityManager;
import com.dkellycollins.triggerfinger.managers.state.IStateManager;
import com.dkellycollins.triggerfinger.managers.state.impl.PlayerStateManager;
import com.dkellycollins.triggerfinger.managers.view.IViewManager;
import com.dkellycollins.triggerfinger.managers.view.impl.PlayerViewManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Devin on 8/22/2015.
 */
public class GameView extends SurfaceView {

    private GameThread _gameThread;

    public GameView(Context context) {
        super(context);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        
        ITouchPositionDao touchPositionDao = new TouchPositionDao(this);
        ICollidableEntityManager collidableEntityManager = new CollidableEntityManager(new EntityDao<ICollidable>());
        IPlayerEntityManager playerEntityManager = new PlayerEntityManager(new EntityDao<IPlayer>(), collidableEntityManager);

        List<IStateManager> stateManagers = new ArrayList<IStateManager>();
        stateManagers.add(new PlayerStateManager(playerEntityManager, collidableEntityManager, touchPositionDao));

        List<IViewManager> viewManagers = new ArrayList<IViewManager>();
        viewManagers.add(new PlayerViewManager(playerEntityManager, collidableEntityManager));

        _gameThread = new GameThread(this, stateManagers, viewManagers);
        _gameThread.setActive(true);
        _gameThread.run();
    }
}
