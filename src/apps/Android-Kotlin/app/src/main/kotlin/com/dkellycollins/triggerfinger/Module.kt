package com.dkellycollins.triggerfinger

import android.content.Context
import android.view.View

import com.dkellycollins.triggerfinger.data.config.IBulletConfig
import com.dkellycollins.triggerfinger.data.config.IEnemyConfig
import com.dkellycollins.triggerfinger.data.config.IFontConfig
import com.dkellycollins.triggerfinger.data.config.IPlayerConfig
import com.dkellycollins.triggerfinger.data.config.impl.BulletConfig
import com.dkellycollins.triggerfinger.data.config.impl.EnemyConfig
import com.dkellycollins.triggerfinger.data.config.impl.FontConfig
import com.dkellycollins.triggerfinger.data.config.impl.PlayerConfig
import com.dkellycollins.triggerfinger.data.daos.IActivityDao
import com.dkellycollins.triggerfinger.data.daos.IBitmapDao
import com.dkellycollins.triggerfinger.data.daos.IBulletDao
import com.dkellycollins.triggerfinger.data.daos.ICollidableDao
import com.dkellycollins.triggerfinger.data.daos.IDeviceInfoDao
import com.dkellycollins.triggerfinger.data.daos.IEnemyDao
import com.dkellycollins.triggerfinger.data.daos.IPlayerDao
import com.dkellycollins.triggerfinger.data.daos.ITimerDao
import com.dkellycollins.triggerfinger.data.daos.ITouchPositionDao
import com.dkellycollins.triggerfinger.data.daos.IWeaponDao
import com.dkellycollins.triggerfinger.data.daos.impl.BitmapDao
import com.dkellycollins.triggerfinger.data.daos.impl.BulletDao
import com.dkellycollins.triggerfinger.data.daos.impl.CollidableDao
import com.dkellycollins.triggerfinger.data.daos.impl.DeviceInfoDao
import com.dkellycollins.triggerfinger.data.daos.impl.EnemyDao
import com.dkellycollins.triggerfinger.data.daos.impl.PlayerDao
import com.dkellycollins.triggerfinger.data.daos.impl.TimerDao
import com.dkellycollins.triggerfinger.data.daos.impl.TouchPositionDao
import com.dkellycollins.triggerfinger.data.daos.impl.WeaponDao
import com.dkellycollins.triggerfinger.managers.entity.IBitmapEntityManager
import com.dkellycollins.triggerfinger.managers.entity.IBulletEntityManager
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager
import com.dkellycollins.triggerfinger.managers.entity.IEnemyEntityManager
import com.dkellycollins.triggerfinger.managers.entity.IPlayerEntityManager
import com.dkellycollins.triggerfinger.managers.entity.ITimerEntityManager
import com.dkellycollins.triggerfinger.managers.entity.IWeaponEntityManager
import com.dkellycollins.triggerfinger.managers.entity.impl.BitmapEntityManager
import com.dkellycollins.triggerfinger.managers.entity.impl.BulletEntityManager
import com.dkellycollins.triggerfinger.managers.entity.impl.CollidableEntityManager
import com.dkellycollins.triggerfinger.managers.entity.impl.EnemyEntityManager
import com.dkellycollins.triggerfinger.managers.entity.impl.PlayerEntityManager
import com.dkellycollins.triggerfinger.managers.entity.impl.TimerEntityManager
import com.dkellycollins.triggerfinger.managers.entity.impl.WeaponEntityManager
import com.dkellycollins.triggerfinger.managers.events.IEventDispatcher
import com.dkellycollins.triggerfinger.managers.events.IEventInterceptor
import com.dkellycollins.triggerfinger.managers.events.impl.EventDispatcher
import com.dkellycollins.triggerfinger.managers.events.impl.interceptors.collisions.BulletEnemyCollisionInterceptor
import com.dkellycollins.triggerfinger.managers.events.impl.interceptors.collisions.PlayerEnemyCollisionInterceptor
import com.dkellycollins.triggerfinger.managers.state.IStateManager
import com.dkellycollins.triggerfinger.managers.state.impl.BulletStateManager
import com.dkellycollins.triggerfinger.managers.state.impl.CollisionStateManager
import com.dkellycollins.triggerfinger.managers.state.impl.EnemyStateManager
import com.dkellycollins.triggerfinger.managers.state.impl.PlayerStateManager
import com.dkellycollins.triggerfinger.managers.state.impl.TimerStateManager
import com.dkellycollins.triggerfinger.managers.state.impl.WeaponStateManager
import com.dkellycollins.triggerfinger.managers.view.IViewManager
import com.dkellycollins.triggerfinger.managers.view.impl.EnemyViewManager
import com.dkellycollins.triggerfinger.managers.view.impl.PlayerViewManager
import com.dkellycollins.triggerfinger.managers.view.impl.gui.ScoreViewManager
import com.dkellycollins.triggerfinger.managers.view.impl.debug.BulletHitboxViewManager
import com.dkellycollins.triggerfinger.managers.view.impl.debug.EnemyHitboxViewManager
import com.dkellycollins.triggerfinger.managers.view.impl.debug.PlayerHitboxViewManager
import com.dkellycollins.triggerfinger.util.logger.ILogWriter
import com.dkellycollins.triggerfinger.util.logger.ILogger
import com.dkellycollins.triggerfinger.util.logger.impl.Logger
import com.dkellycollins.triggerfinger.util.logger.impl.SystemLogWriter

import java.util.ArrayList
import java.util.Collections
import java.util.Comparator
import java.util.Random

class Module(activeView: View, context: Context) {

    private val _viewManagers: MutableList<IViewManager>
    private val _stateManagers: MutableList<IStateManager>
    private val _activityDaos: MutableList<IActivityDao>
    val logger: ILogger

    init {

        //Util
        val logWriters = ArrayList<ILogWriter>()
        logWriters.add(SystemLogWriter())
        logger = Logger(logWriters)
        val random = Random()

        //Config
        val bulletConfig = BulletConfig(context)
        val enemyConfig = EnemyConfig(context)
        val playerConfig = PlayerConfig(context)
        val fontConfig = FontConfig(context)

        //Data
        val touchPositionDao = TouchPositionDao(activeView)
        val deviceInfoDao = DeviceInfoDao(activeView)
        val collidableDao = CollidableDao()
        val playerDao = PlayerDao()
        val enemyDao = EnemyDao()
        val timerDao = TimerDao()
        val weaponDao = WeaponDao()
        val bulletDao = BulletDao()
        val bitmapDao = BitmapDao(context)

        _activityDaos = ArrayList<IActivityDao>()
        _activityDaos.add(collidableDao)
        _activityDaos.add(playerDao)
        _activityDaos.add(enemyDao)
        _activityDaos.add(timerDao)
        _activityDaos.add(weaponDao)
        _activityDaos.add(bulletDao)

        //Entity managers.
        val collidableEntityManager = CollidableEntityManager(collidableDao)
        val timerEntityManager = TimerEntityManager(timerDao)
        val weaponEntityManager = WeaponEntityManager(weaponDao, bulletConfig, timerEntityManager)
        val bulletEntityManager = BulletEntityManager(bulletDao, bulletConfig, collidableEntityManager)
        val playerEntityManager = PlayerEntityManager(playerDao, playerConfig, collidableEntityManager, weaponEntityManager, timerEntityManager)
        val enemyEntityManager = EnemyEntityManager(enemyDao, enemyConfig, collidableEntityManager)
        val bitmapEnityManager = BitmapEntityManager(bitmapDao)

        //Interceptors
        val interceptors = ArrayList<IEventInterceptor>()
        interceptors.add(BulletEnemyCollisionInterceptor(bulletEntityManager, enemyEntityManager, playerEntityManager))
        //interceptors.add(new BulletPlayerCollisionInterceptor(bulletEntityManager, playerEntityManager));
        interceptors.add(PlayerEnemyCollisionInterceptor(playerEntityManager, enemyEntityManager, timerEntityManager))

        //Dispatchers
        val dispatcher = EventDispatcher(interceptors)

        //State managers.
        _stateManagers = ArrayList<IStateManager>()
        _stateManagers.add(CollisionStateManager(collidableEntityManager, dispatcher))
        _stateManagers.add(PlayerStateManager(playerEntityManager, collidableEntityManager, touchPositionDao, weaponEntityManager, timerEntityManager))
        _stateManagers.add(EnemyStateManager(enemyEntityManager, enemyConfig, collidableEntityManager, timerEntityManager, deviceInfoDao, random))
        _stateManagers.add(TimerStateManager(timerEntityManager))
        _stateManagers.add(WeaponStateManager(weaponEntityManager, timerEntityManager, bulletEntityManager, collidableEntityManager))
        _stateManagers.add(BulletStateManager(bulletEntityManager, collidableEntityManager, deviceInfoDao))

        //View managers.
        _viewManagers = ArrayList<IViewManager>()
        //_viewManagers.add(new BulletViewManager(bulletConfig, bulletEntityManager, collidableEntityManager, bitmapEnityManager));
        _viewManagers.add(PlayerViewManager(playerEntityManager, playerConfig, collidableEntityManager, bitmapEnityManager))
        _viewManagers.add(EnemyViewManager(enemyConfig, bitmapEnityManager, enemyEntityManager, collidableEntityManager))
        _viewManagers.add(PlayerHitboxViewManager(playerEntityManager, collidableEntityManager))
        _viewManagers.add(EnemyHitboxViewManager(enemyEntityManager, collidableEntityManager))
        _viewManagers.add(BulletHitboxViewManager(bulletEntityManager, collidableEntityManager))
        _viewManagers.add(ScoreViewManager(context, fontConfig, playerEntityManager))

        Collections.sort(_viewManagers) { lhs, rhs -> lhs.layer.compareTo(rhs.layer) }
    }

    val stateManagers: List<IStateManager>
        get() = _stateManagers

    val viewManagers: List<IViewManager>
        get() = _viewManagers

    val activityDaos: List<IActivityDao>
        get() = _activityDaos

}
