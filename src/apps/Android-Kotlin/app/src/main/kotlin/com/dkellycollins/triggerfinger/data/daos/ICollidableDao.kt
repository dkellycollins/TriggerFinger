package com.dkellycollins.triggerfinger.data.daos

import com.dkellycollins.triggerfinger.data.entity.ICollidable
import com.dkellycollins.triggerfinger.data.model.IVector

/**
 * Provides the ability to manage collidable data.
 */
interface ICollidableDao : IActivityDao {

    fun retrieve(): Iterable<ICollidable>
    fun retrieve(id: Int): ICollidable

    fun create(position: IVector, radius: Float): Int

    fun update(id: Int, position: IVector, radius: Float)

    fun delete(id: Int)

}
