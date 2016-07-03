package com.dkellycollins.triggerfinger.managers.view.impl.debug

import android.graphics.Color

import com.dkellycollins.triggerfinger.data.entity.ICollidable
import com.dkellycollins.triggerfinger.data.entity.IEnemy
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager
import com.dkellycollins.triggerfinger.managers.entity.IEnemyEntityManager

import java.util.ArrayList

class EnemyHitboxViewManager(private val _enemyManager: IEnemyEntityManager, private val _collidableManager: ICollidableEntityManager) : BaseHitboxViewManager() {

    protected override val color: Int
        get() = Color.RED

    protected override val collidables: Iterable<ICollidable>
        get() {
            val collidables = ArrayList<ICollidable>()

            for (enemy in _enemyManager.retrieve()) {
                collidables.add(_collidableManager.retrieve(enemy.collidableId))
            }

            return collidables
        }
}
