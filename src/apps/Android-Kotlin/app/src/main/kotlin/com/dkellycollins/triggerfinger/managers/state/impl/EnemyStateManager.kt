package com.dkellycollins.triggerfinger.managers.state.impl

import com.dkellycollins.triggerfinger.data.config.IEnemyConfig
import com.dkellycollins.triggerfinger.data.daos.IDeviceInfoDao
import com.dkellycollins.triggerfinger.data.entity.ICollidable
import com.dkellycollins.triggerfinger.data.entity.IEnemy
import com.dkellycollins.triggerfinger.data.entity.ITimer
import com.dkellycollins.triggerfinger.data.model.impl.Vector2
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager
import com.dkellycollins.triggerfinger.managers.entity.IEnemyEntityManager
import com.dkellycollins.triggerfinger.managers.entity.ITimerEntityManager
import com.dkellycollins.triggerfinger.managers.state.IStateManager

import java.util.ArrayList
import java.util.Random

/**
 * Created by Devin on 9/5/2015.
 */
class EnemyStateManager(private val _enemyManager: IEnemyEntityManager, private val _enemyConfig: IEnemyConfig, private val _collidableManager: ICollidableEntityManager, private val _timerManager: ITimerEntityManager, private val _deviceDao: IDeviceInfoDao, private val _random: Random) : IStateManager {

    private var _timerId: Int = 0
    private val _toDelete: MutableList<Int>

    init {

        _toDelete = ArrayList<Int>()
    }

    override fun init() {
        _timerId = _timerManager.create(_enemyConfig.respawnRate, true)
        createEnemy()
    }

    override fun update(deltaTime: Long) {
        val timer = _timerManager.retrieve(_timerId)

        if (timer.currentTime == 0) {
            createEnemy()
            _timerManager.reset(_timerId)
        }

        for (enemy in _enemyManager.retrieve()) {
            val position = _collidableManager.retrieve(enemy.collidableId)

            if (position.center.y > _deviceDao.height) {
                _toDelete.add(enemy.id)
            } else {
                val dY = _enemyConfig.deltaY * (deltaTime.toFloat() / 1000)
                _collidableManager.update(position.id, Vector2(position.center.x, position.center.y + dY, 0f), position.radius)
            }
        }

        for (id in _toDelete) {
            _enemyManager.delete(id)
        }
        _toDelete.clear()
    }

    private fun createEnemy() {
        val x = _random.nextInt(_deviceDao.width)
        _enemyManager.create(Vector2(x.toFloat(), 0f, 0f))
    }
}
