package com.dkellycollins.triggerfinger.data.daos

import com.dkellycollins.triggerfinger.data.entity.IEnemy

/**
 * Provides the ability to manage enemy data.
 */
interface IEnemyDao : IActivityDao {

    fun create(collidableId: Int): Int

    fun retrieve(): Iterable<IEnemy>
    fun retrieve(id: Int): IEnemy

    fun update(id: Int, collidableId: Int)

    fun delete(id: Int)

}
