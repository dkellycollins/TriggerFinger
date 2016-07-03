package com.dkellycollins.triggerfinger.managers.state.impl

import com.dkellycollins.triggerfinger.data.entity.ICollidable
import com.dkellycollins.triggerfinger.data.model.IVector
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager
import com.dkellycollins.triggerfinger.managers.events.IEventDispatcher
import com.dkellycollins.triggerfinger.managers.events.impl.events.CollisionEvent
import com.dkellycollins.triggerfinger.managers.state.IStateManager
import com.dkellycollins.triggerfinger.util.IterableUtil
import com.dkellycollins.triggerfinger.util.MathUtil

class CollisionStateManager(private val _collidableManager: ICollidableEntityManager, private val _dispatcher: IEventDispatcher) : IStateManager {

    override fun init() {

    }

    override fun update(deltaTime: Long) {

        val collidables = IterableUtil.toArrayList(_collidableManager.retrieve())

        for (i in collidables.indices) {
            val item1 = collidables[i]
            for (j in i + 1..collidables.size - 1) {
                val item2 = collidables[j]

                if (isCollision(item1, item2)) {
                    _dispatcher.dispatch(CollisionEvent(item1.id, item2.id))
                }
            }
        }
    }

    private fun isCollision(item1: ICollidable, item2: ICollidable): Boolean {
        val item1Pos = item1.center
        val item2Pos = item2.center
        val d2 = MathUtil.distanceSquared(item1Pos.x, item2Pos.x, item1Pos.y, item2Pos.y)
        val d = Math.sqrt(d2.toDouble()).toFloat()

        val r = item1.radius + item2.radius

        return d <= r
    }
}
