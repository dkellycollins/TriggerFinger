package com.dkellycollins.triggerfinger.managers.events.impl.interceptors.collisions

import com.dkellycollins.triggerfinger.data.entity.IBullet
import com.dkellycollins.triggerfinger.data.entity.IPlayer
import com.dkellycollins.triggerfinger.managers.entity.IBulletEntityManager
import com.dkellycollins.triggerfinger.managers.entity.IPlayerEntityManager
import com.dkellycollins.triggerfinger.managers.events.IEventInterceptor
import com.dkellycollins.triggerfinger.managers.events.IEvent
import com.dkellycollins.triggerfinger.managers.events.impl.events.CollisionEvent

class BulletPlayerCollisionInterceptor(private val _bulletManager: IBulletEntityManager, private val _playerManager: IPlayerEntityManager) : IEventInterceptor {

    override fun handlesMessage(event: IEvent): Boolean {
        return event is CollisionEvent
    }

    override fun invoke(event: IEvent) {
        val m = event as CollisionEvent

        val player = getPlayer(m.item1, m.item2)
        val bullet = getBullet(m.item1, m.item2)

        if (player != null && bullet != null) {
            onCollision(bullet, player)
        }
    }

    fun onCollision(bullet: IBullet, player: IPlayer) {
        _bulletManager.delete(bullet.id)
    }

    private fun getPlayer(item1: Int, item2: Int): IPlayer? {
        val player = _playerManager.retrievePlayerOne()

        if (player.collidableId == item1 || player.collidableId == item2) {
            return player
        }
        return null
    }

    private fun getBullet(item1: Int, item2: Int): IBullet? {
        var bullet: IBullet? = _bulletManager.retrieveByCollidable(item1)
        if (bullet == null) {
            bullet = _bulletManager.retrieveByCollidable(item2)
        }

        return bullet
    }
}
