package com.dkellycollins.triggerfinger.managers.events.impl.interceptors.collisions

import com.dkellycollins.triggerfinger.data.entity.IBullet
import com.dkellycollins.triggerfinger.data.entity.IEnemy
import com.dkellycollins.triggerfinger.data.entity.IPlayer
import com.dkellycollins.triggerfinger.managers.entity.IBulletEntityManager
import com.dkellycollins.triggerfinger.managers.entity.IEnemyEntityManager
import com.dkellycollins.triggerfinger.managers.entity.IPlayerEntityManager
import com.dkellycollins.triggerfinger.managers.events.IEventInterceptor
import com.dkellycollins.triggerfinger.managers.events.IEvent
import com.dkellycollins.triggerfinger.managers.events.impl.events.CollisionEvent

class BulletEnemyCollisionInterceptor(private val _bulletManager: IBulletEntityManager, private val _enemyManager: IEnemyEntityManager, private val _playerManager: IPlayerEntityManager) : IEventInterceptor {

    override fun handlesMessage(event: IEvent): Boolean {
        return event is CollisionEvent
    }

    override fun invoke(event: IEvent) {
        val m = event as CollisionEvent

        val bullet = getBullet(m.item1, m.item2)
        val enemy = getEnemy(m.item1, m.item2)

        if (bullet != null && enemy != null) {
            onCollision(bullet, enemy)
        }
    }

    fun onCollision(bullet: IBullet, enemy: IEnemy) {
        _bulletManager.delete(bullet.id)
        _enemyManager.delete(enemy.id)

        val player = _playerManager.retrievePlayerOne()
        if (player != null) {
            _playerManager.update(player.id, player.score + 50, player.health)
        }
    }

    private fun getBullet(item1: Int, item2: Int): IBullet? {
        var bullet: IBullet? = _bulletManager.retrieveByCollidable(item1)
        if (bullet == null) {
            bullet = _bulletManager.retrieveByCollidable(item2)
        }

        return bullet
    }

    private fun getEnemy(item1: Int, item2: Int): IEnemy? {
        var enemy: IEnemy? = _enemyManager.retrieveByCollidable(item1)
        if (enemy == null) {
            enemy = _enemyManager.retrieveByCollidable(item2)
        }

        return enemy
    }
}
