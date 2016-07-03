package com.dkellycollins.triggerfinger.data.daos

import com.dkellycollins.triggerfinger.data.entity.IBullet
import com.dkellycollins.triggerfinger.data.model.IVector

/**
 * Provides the ability to manage bullet data.
 */
interface IBulletDao : IActivityDao {

    fun retrieve(): Iterable<IBullet>
    fun retrieve(id: Int): IBullet

    fun create(collidableId: Int, velocity: IVector): Int

    fun delete(id: Int)

}
