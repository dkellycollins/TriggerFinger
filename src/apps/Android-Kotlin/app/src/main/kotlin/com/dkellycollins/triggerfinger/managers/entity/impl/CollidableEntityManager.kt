package com.dkellycollins.triggerfinger.managers.entity.impl

import com.dkellycollins.triggerfinger.data.daos.ICollidableDao
import com.dkellycollins.triggerfinger.data.entity.ICollidable
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager
import com.dkellycollins.triggerfinger.data.model.IVector

class CollidableEntityManager(private val _dao: ICollidableDao) : ICollidableEntityManager {

    override fun retrieve(): Iterable<ICollidable> {
        return _dao.retrieve()
    }

    override fun retrieve(id: Int): ICollidable {
        return _dao.retrieve(id)
    }

    override fun create(position: IVector, radius: Float): Int {
        return _dao.create(position, radius)
    }

    override fun update(id: Int, position: IVector, radius: Float) {
        _dao.update(id, position, radius)
    }

    override fun delete(id: Int) {
        _dao.delete(id)
    }
}
