package com.dkellycollins.triggerfinger.managers.entity

import com.dkellycollins.triggerfinger.data.entity.ICollidable
import com.dkellycollins.triggerfinger.data.model.IVector

interface ICollidableEntityManager : IEntityManager {

    fun retrieve(): Iterable<ICollidable>

    fun retrieve(id: Int): ICollidable

    fun create(position: IVector, radius: Float): Int

    fun update(id: Int, position: IVector, radius: Float)

    fun delete(id: Int)

}
