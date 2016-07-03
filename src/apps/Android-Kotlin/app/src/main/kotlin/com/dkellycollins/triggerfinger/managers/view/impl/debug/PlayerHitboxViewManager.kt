package com.dkellycollins.triggerfinger.managers.view.impl.debug

import android.graphics.Color

import com.dkellycollins.triggerfinger.data.entity.ICollidable
import com.dkellycollins.triggerfinger.data.entity.IPlayer
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager
import com.dkellycollins.triggerfinger.managers.entity.IPlayerEntityManager

import java.util.ArrayList

class PlayerHitboxViewManager(private val _playerManager: IPlayerEntityManager, private val _collidableManager: ICollidableEntityManager) : BaseHitboxViewManager() {

    protected override val color: Int
        get() = Color.GREEN

    protected override val collidables: Iterable<ICollidable>
        get() {
            val collidables = ArrayList<ICollidable>()

            for (player in _playerManager.retrieve()) {
                collidables.add(_collidableManager.retrieve(player.collidableId))
            }

            return collidables
        }
}
