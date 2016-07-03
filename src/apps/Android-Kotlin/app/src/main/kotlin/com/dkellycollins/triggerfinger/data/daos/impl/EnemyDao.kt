package com.dkellycollins.triggerfinger.data.daos.impl

import com.dkellycollins.triggerfinger.data.daos.IEnemyDao
import com.dkellycollins.triggerfinger.data.entity.IEnemy
import com.dkellycollins.triggerfinger.data.entity.IPlayer
import com.dkellycollins.triggerfinger.data.entity.impl.Enemy
import com.dkellycollins.triggerfinger.data.entity.impl.Player

import java.util.HashMap

class EnemyDao : BaseEntityDao<Enemy>("EnemyDao"), IEnemyDao {

    override fun create(collidableId: Int): Int {
        val id = nextId
        val enemy = Enemy(id, collidableId)

        _store.put(id, enemy)

        return id
    }

    override fun retrieve(): Iterable<IEnemy> {
        return _store.values
    }

    override fun retrieve(id: Int): IEnemy {
        if (!_store.containsKey(id)) {
            throw RuntimeException(String.format("Key {0} not found", id))
        }

        return _store[id]
    }

    override fun update(id: Int, collidableId: Int) {
        if (!_store.containsKey(id)) {
            throw RuntimeException(String.format("Key {0} not found", id))
        }

        val enemy = _store[id]
        enemy.collidableId = collidableId
    }

    override fun delete(id: Int) {
        if (!_store.containsKey(id)) {
            throw RuntimeException(String.format("Key {0} not found", id))
        }

        _store.remove(id)
    }

}
