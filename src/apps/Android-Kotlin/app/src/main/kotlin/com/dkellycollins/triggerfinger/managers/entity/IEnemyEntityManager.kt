package com.dkellycollins.triggerfinger.managers.entity

import com.dkellycollins.triggerfinger.data.entity.IEnemy
import com.dkellycollins.triggerfinger.data.model.IVector

interface IEnemyEntityManager {

    fun retrieve(): Iterable<IEnemy>
    fun retrieve(enemyId: Int): IEnemy
    fun retrieveByCollidable(collidableId: Int): IEnemy

    fun create(position: IVector): Int

    fun delete(playerId: Int)

}
