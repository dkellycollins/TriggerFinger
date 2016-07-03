package com.dkellycollins.triggerfinger.managers.state.impl

import com.dkellycollins.triggerfinger.data.daos.IDeviceInfoDao
import com.dkellycollins.triggerfinger.data.entity.IBullet
import com.dkellycollins.triggerfinger.data.entity.ICollidable
import com.dkellycollins.triggerfinger.data.model.IVector
import com.dkellycollins.triggerfinger.data.model.impl.Vector2
import com.dkellycollins.triggerfinger.managers.entity.IBulletEntityManager
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager
import com.dkellycollins.triggerfinger.managers.state.IStateManager

import java.util.ArrayList

class BulletStateManager(private val _bulletManager: IBulletEntityManager, private val _collidableManager: ICollidableEntityManager, private val _deviceInfo: IDeviceInfoDao) : IStateManager {
    private val _toRemove: MutableList<Int>

    init {
        _toRemove = ArrayList<Int>()
    }

    override fun init() {

    }

    override fun update(deltaTime: Long) {

        for (bullet in _bulletManager.retrieve()) {
            val collidable = _collidableManager.retrieve(bullet.collidableId)

            val maxX = _deviceInfo.width
            val maxY = _deviceInfo.height
            val center = collidable.center

            if (center.x < 0 || center.x > maxX) {
                _toRemove.add(bullet.id)
            } else if (center.y < 0 || center.y > maxY) {
                _toRemove.add(bullet.id)
            } else {
                val velocity = bullet.velocity

                val dX = velocity.x * velocity.length * (deltaTime.toFloat() / 1000)
                val dY = velocity.y * velocity.length * (deltaTime.toFloat() / 1000)
                _collidableManager.update(collidable.id, Vector2(center.x + dX, center.y + dY, 0f), collidable.radius)
            }
        }

        for (id in _toRemove) {
            _bulletManager.delete(id)
        }
        _toRemove.clear()
    }
}
