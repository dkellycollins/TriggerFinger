package com.dkellycollins.triggerfinger;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.dkellycollins.triggerfinger.data.config.IBulletConfig;
import com.dkellycollins.triggerfinger.data.config.IEnemyConfig;
import com.dkellycollins.triggerfinger.data.config.IPlayerConfig;
import com.dkellycollins.triggerfinger.data.config.impl.BulletConfig;
import com.dkellycollins.triggerfinger.data.config.impl.EnemyConfig;
import com.dkellycollins.triggerfinger.data.config.impl.PlayerConfig;
import com.dkellycollins.triggerfinger.data.daos.IBitmapDao;
import com.dkellycollins.triggerfinger.data.daos.IBulletDao;
import com.dkellycollins.triggerfinger.data.daos.ICollidableDao;
import com.dkellycollins.triggerfinger.data.daos.IDeviceInfoDao;
import com.dkellycollins.triggerfinger.data.daos.IEnemyDao;
import com.dkellycollins.triggerfinger.data.daos.IPlayerDao;
import com.dkellycollins.triggerfinger.data.daos.ITimerDao;
import com.dkellycollins.triggerfinger.data.daos.ITouchPositionDao;
import com.dkellycollins.triggerfinger.data.daos.IWeaponDao;
import com.dkellycollins.triggerfinger.data.daos.impl.BitmapDao;
import com.dkellycollins.triggerfinger.data.daos.impl.BulletDao;
import com.dkellycollins.triggerfinger.data.daos.impl.CollidableDao;
import com.dkellycollins.triggerfinger.data.daos.impl.DeviceInfoDao;
import com.dkellycollins.triggerfinger.data.daos.impl.EnemyDao;
import com.dkellycollins.triggerfinger.data.daos.impl.PlayerDao;
import com.dkellycollins.triggerfinger.data.daos.impl.TimerDao;
import com.dkellycollins.triggerfinger.data.daos.impl.TouchPositionDao;
import com.dkellycollins.triggerfinger.data.daos.impl.WeaponDao;
import com.dkellycollins.triggerfinger.managers.entity.IBitmapEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IBulletEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IEnemyEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IPlayerEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.ITimerEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IWeaponEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.impl.BitmapEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.impl.BulletEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.impl.CollidableEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.impl.EnemyEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.impl.PlayerEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.impl.TimerEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.impl.WeaponEntityManager;
import com.dkellycollins.triggerfinger.managers.state.IStateManager;
import com.dkellycollins.triggerfinger.managers.state.impl.BulletStateManager;
import com.dkellycollins.triggerfinger.managers.state.impl.EnemyStateManager;
import com.dkellycollins.triggerfinger.managers.state.impl.PlayerStateManager;
import com.dkellycollins.triggerfinger.managers.state.impl.TimerStateManager;
import com.dkellycollins.triggerfinger.managers.state.impl.WeaponStateManager;
import com.dkellycollins.triggerfinger.managers.view.IViewManager;
import com.dkellycollins.triggerfinger.managers.view.impl.BulletViewManager;
import com.dkellycollins.triggerfinger.managers.view.impl.PlayerViewManager;
import com.dkellycollins.triggerfinger.managers.view.impl.debug.BulletHitboxViewManager;
import com.dkellycollins.triggerfinger.managers.view.impl.debug.EnemyHitboxViewManager;
import com.dkellycollins.triggerfinger.managers.view.impl.debug.PlayerHitboxViewManager;
import com.dkellycollins.triggerfinger.util.logger.ILogWriter;
import com.dkellycollins.triggerfinger.util.logger.ILogger;
import com.dkellycollins.triggerfinger.util.logger.impl.Logger;
import com.dkellycollins.triggerfinger.util.logger.impl.SystemLogWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        Random random = new Random();

        //Config
        IBulletConfig bulletConfig = new BulletConfig(getContext());
        IEnemyConfig enemyConfig = new EnemyConfig(getContext());
        IPlayerConfig playerConfig = new PlayerConfig(getContext());

        //Data
        ITouchPositionDao touchPositionDao = new TouchPositionDao(this);
        IDeviceInfoDao deviceInfoDao = new DeviceInfoDao(this);
        ICollidableDao collidableDao = new CollidableDao();
        IPlayerDao playerDao = new PlayerDao();
        IEnemyDao enemyDao = new EnemyDao();
        ITimerDao timerDao = new TimerDao();
        IWeaponDao weaponDao = new WeaponDao();
        IBulletDao bulletDao = new BulletDao();
        IBitmapDao bitmapDao = new BitmapDao(getContext());

        //Entity managers.
        ICollidableEntityManager collidableEntityManager = new CollidableEntityManager(collidableDao);
        ITimerEntityManager timerEntityManager = new TimerEntityManager(timerDao);
        IWeaponEntityManager weaponEntityManager = new WeaponEntityManager(weaponDao, bulletConfig, timerEntityManager);
        IBulletEntityManager bulletEntityManager = new BulletEntityManager(bulletDao, bulletConfig, collidableEntityManager);
        IPlayerEntityManager playerEntityManager = new PlayerEntityManager(playerDao, playerConfig, collidableEntityManager, weaponEntityManager);
        IEnemyEntityManager enemyEntityManager = new EnemyEntityManager(enemyDao, enemyConfig, collidableEntityManager);
        IBitmapEntityManager bitmapEnityManager = new BitmapEntityManager(bitmapDao);

        //State managers.
        List<IStateManager> stateManagers = new ArrayList<IStateManager>();
        stateManagers.add(new PlayerStateManager(playerEntityManager, collidableEntityManager, touchPositionDao, weaponEntityManager, timerEntityManager));
        stateManagers.add(new EnemyStateManager(enemyEntityManager, enemyConfig, collidableEntityManager, timerEntityManager, deviceInfoDao, random));
        stateManagers.add(new TimerStateManager(timerEntityManager));
        stateManagers.add(new WeaponStateManager(weaponEntityManager, timerEntityManager, bulletEntityManager, collidableEntityManager));
        stateManagers.add(new BulletStateManager(bulletEntityManager, collidableEntityManager, deviceInfoDao));

        //View managers.
        List<IViewManager> viewManagers = new ArrayList<IViewManager>();
        viewManagers.add(new BulletViewManager(bulletConfig, bulletEntityManager, collidableEntityManager, bitmapEnityManager));
        viewManagers.add(new PlayerViewManager(playerEntityManager, playerConfig, collidableEntityManager, bitmapEnityManager));
        viewManagers.add(new PlayerHitboxViewManager(playerEntityManager, collidableEntityManager));
        viewManagers.add(new EnemyHitboxViewManager(enemyEntityManager, collidableEntityManager));
        viewManagers.add(new BulletHitboxViewManager(bulletEntityManager, collidableEntityManager));

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
