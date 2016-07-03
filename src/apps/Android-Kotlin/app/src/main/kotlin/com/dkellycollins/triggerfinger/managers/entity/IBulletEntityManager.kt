package com.dkellycollins.triggerfinger.managers.entity

import com.dkellycollins.triggerfinger.data.entity.IBullet
import com.dkellycollins.triggerfinger.data.model.IVector

/**
 * Created by Devin on 9/6/2015.
 */
interface IBulletEntityManager {

    fun retrieve(): Iterable<IBullet>
    fun retrieve(id: Int): IBullet
    fun retrieveByCollidable(collidableId: Int): IBullet

    fun create(startingPosition: IVector): Int

    fun delete(id: Int)

}
