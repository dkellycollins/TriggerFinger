package com.dkellycollins.triggerfinger.managers.entity.impl

import com.dkellycollins.triggerfinger.data.config.IEnemyConfig
import com.dkellycollins.triggerfinger.data.daos.IEnemyDao
import com.dkellycollins.triggerfinger.data.entity.IEnemy
import com.dkellycollins.triggerfinger.data.model.IVector
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager
import com.dkellycollins.triggerfinger.managers.entity.IEnemyEntityManager

class EnemyEntityManager(private val _dao: IEnemyDao, private val _config: IEnemyConfig, private val _collidableManager: ICollidableEntityManager) : IEnemyEntityManager {

    override fun retrieve(): Iterable<IEnemy> {
        return _dao.retrieve()
    }

    override fun retrieve(id: Int): IEnemy {
        return _dao.retrieve(id)
    }

    override fun retrieveByCollidable(collidableId: Int): IEnemy {
        for (enemy in _dao.retrieve()) {
            if (enemy.collidableId == collidableId) {
                return enemy
            }
        }

        return null
    }

    override fun create(position: IVector): Int {
        val collidableId = _collidableManager.create(position, _config.collidableRadius)
        return _dao.create(collidableId)
    }

    override fun delete(id: Int) {
        val enemy = _dao.retrieve(id)
        _dao.delete(id)
        _collidableManager.delete(enemy.collidableId)
    }
}
