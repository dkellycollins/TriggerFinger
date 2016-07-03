package com.dkellycollins.triggerfinger.managers.entity.impl

import com.dkellycollins.triggerfinger.data.config.IBulletConfig
import com.dkellycollins.triggerfinger.data.daos.IBulletDao
import com.dkellycollins.triggerfinger.data.entity.IBullet
import com.dkellycollins.triggerfinger.data.model.IVector
import com.dkellycollins.triggerfinger.data.model.impl.Vector2
import com.dkellycollins.triggerfinger.managers.entity.IBulletEntityManager
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager

class BulletEntityManager(private val _dao: IBulletDao, private val _config: IBulletConfig, private val _collidableManager: ICollidableEntityManager) : IBulletEntityManager {

    override fun retrieve(): Iterable<IBullet> {
        return _dao.retrieve()
    }

    override fun retrieve(id: Int): IBullet {
        return _dao.retrieve(id)
    }

    override fun retrieveByCollidable(collidableId: Int): IBullet {
        for (bullet in _dao.retrieve()) {
            if (bullet.collidableId == collidableId) {
                return bullet
            }
        }

        return null
    }

    override fun create(startingPosition: IVector): Int {
        val collidableId = _collidableManager.create(startingPosition, _config.collidableRadius)
        val velocity = _config.velocity

        return _dao.create(collidableId, velocity)
    }

    override fun delete(id: Int) {
        val bullet = _dao.retrieve(id)

        _collidableManager.delete(bullet.collidableId)
        _dao.delete(id)
    }
}
