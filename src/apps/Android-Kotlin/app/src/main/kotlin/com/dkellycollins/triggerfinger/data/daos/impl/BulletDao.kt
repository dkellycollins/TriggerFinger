package com.dkellycollins.triggerfinger.data.daos.impl

import android.os.Bundle

import com.dkellycollins.triggerfinger.data.daos.IBulletDao
import com.dkellycollins.triggerfinger.data.entity.IBullet
import com.dkellycollins.triggerfinger.data.entity.impl.Bullet
import com.dkellycollins.triggerfinger.data.model.IVector

import java.io.Serializable
import java.util.HashMap

/**
 * Standard implementation of IBulletDao.
 */
class BulletDao : BaseEntityDao<Bullet>("BulletDao"), IBulletDao {

    override fun retrieve(): Iterable<IBullet> {
        return _store.values
    }

    override fun retrieve(id: Int): IBullet {
        return _store[id]
    }

    override fun create(collidableId: Int, velocity: IVector): Int {
        val id = nextId
        val bullet = Bullet(id, collidableId, velocity)

        _store.put(id, bullet)

        return id
    }

    override fun delete(id: Int) {
        _store.remove(id)
    }
}