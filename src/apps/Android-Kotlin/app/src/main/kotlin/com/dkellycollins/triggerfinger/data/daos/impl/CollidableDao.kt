package com.dkellycollins.triggerfinger.data.daos.impl

import android.os.Bundle

import com.dkellycollins.triggerfinger.data.daos.ICollidableDao
import com.dkellycollins.triggerfinger.data.entity.ICollidable
import com.dkellycollins.triggerfinger.data.entity.impl.Bullet
import com.dkellycollins.triggerfinger.data.entity.impl.Collidable
import com.dkellycollins.triggerfinger.data.model.IVector

import java.io.Serializable
import java.util.HashMap

class CollidableDao : BaseEntityDao<Collidable>("CollidableDao"), ICollidableDao {

    override fun retrieve(): Iterable<ICollidable> {
        return _store.values
    }

    override fun retrieve(id: Int): ICollidable {
        if (!_store.containsKey(id)) {
            throw RuntimeException(String.format("Key {0} not found", id))
        }

        return _store[id]
    }

    override fun create(position: IVector, radius: Float): Int {
        val id = nextId
        val collidable = Collidable(id, position, radius)

        _store.put(id, collidable)

        return id
    }

    override fun update(id: Int, position: IVector, radius: Float) {
        if (!_store.containsKey(id)) {
            throw RuntimeException(String.format("Key {0} not found", id))
        }

        val collidable = _store[id]
        collidable.center = position
        collidable.radius = radius
    }

    override fun delete(id: Int) {
        if (!_store.containsKey(id)) {
            throw RuntimeException(String.format("Key {0} not found", id))
        }

        _store.remove(id)
    }
}
