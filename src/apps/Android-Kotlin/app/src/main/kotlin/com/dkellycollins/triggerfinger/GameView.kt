package com.dkellycollins.triggerfinger

import android.app.Activity
import android.content.Context
import android.view.SurfaceHolder
import android.view.SurfaceView

import com.dkellycollins.triggerfinger.data.config.IBulletConfig
import com.dkellycollins.triggerfinger.data.config.IEnemyConfig
import com.dkellycollins.triggerfinger.data.config.IPlayerConfig
import com.dkellycollins.triggerfinger.data.config.impl.BulletConfig
import com.dkellycollins.triggerfinger.data.config.impl.EnemyConfig
import com.dkellycollins.triggerfinger.data.config.impl.PlayerConfig
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
import com.dkellycollins.triggerfinger.managers.state.IStateManager
import com.dkellycollins.triggerfinger.managers.state.impl.BulletStateManager
import com.dkellycollins.triggerfinger.managers.state.impl.EnemyStateManager
import com.dkellycollins.triggerfinger.managers.state.impl.PlayerStateManager
import com.dkellycollins.triggerfinger.managers.state.impl.TimerStateManager
import com.dkellycollins.triggerfinger.managers.state.impl.WeaponStateManager
import com.dkellycollins.triggerfinger.managers.view.IViewManager
import com.dkellycollins.triggerfinger.managers.view.impl.BulletViewManager
import com.dkellycollins.triggerfinger.managers.view.impl.PlayerViewManager
import com.dkellycollins.triggerfinger.managers.view.impl.debug.BulletHitboxViewManager
import com.dkellycollins.triggerfinger.managers.view.impl.debug.EnemyHitboxViewManager
import com.dkellycollins.triggerfinger.managers.view.impl.debug.PlayerHitboxViewManager
import com.dkellycollins.triggerfinger.util.logger.ILogWriter
import com.dkellycollins.triggerfinger.util.logger.ILogger
import com.dkellycollins.triggerfinger.util.logger.impl.Logger
import com.dkellycollins.triggerfinger.util.logger.impl.SystemLogWriter

import java.util.ArrayList
import java.util.Random

class GameView(private val _activity: GameActivity) : SurfaceView(_activity), SurfaceHolder.Callback {
    private var _gameThread: GameThread? = null

    init {

        holder.addCallback(this)
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        startThread()
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {

    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        stopThread()
    }

    private fun startThread() {
        if (_gameThread != null) {
            return
        }

        val module = _activity.module
        _gameThread = GameThread(this, module.stateManagers, module.viewManagers, module.logger)
        _gameThread!!.setActive(true)
        _gameThread!!.start()
    }

    private fun stopThread() {
        if (_gameThread == null) {
            return
        }

        _gameThread!!.setActive(false)

        var retry = true
        while (retry) {
            try {
                _gameThread!!.join()
                retry = false
            } catch (e: InterruptedException) {
            }

        }
        _gameThread = null
    }
}
