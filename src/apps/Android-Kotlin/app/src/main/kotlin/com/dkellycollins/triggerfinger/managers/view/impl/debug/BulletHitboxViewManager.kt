package com.dkellycollins.triggerfinger.managers.view.impl.debug

import android.graphics.Color

import com.dkellycollins.triggerfinger.data.entity.IBullet
import com.dkellycollins.triggerfinger.data.entity.ICollidable
import com.dkellycollins.triggerfinger.managers.entity.IBulletEntityManager
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager

import java.util.ArrayList

/**
 * Created by Devin on 9/7/2015.
 */
class BulletHitboxViewManager(private val _bulletManager: IBulletEntityManager, private val _collidableManager: ICollidableEntityManager) : BaseHitboxViewManager() {

    protected override val color: Int
        get() = Color.MAGENTA

    protected override val collidables: Iterable<ICollidable>
        get() {
            val collidables = ArrayList<ICollidable>()

            for (bullet in _bulletManager.retrieve()) {
                collidables.add(_collidableManager.retrieve(bullet.collidableId))
            }

            return collidables
        }
}
