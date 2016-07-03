package com.dkellycollins.triggerfinger.managers.events.impl.interceptors.collisions

import com.dkellycollins.triggerfinger.data.entity.IEnemy
import com.dkellycollins.triggerfinger.data.entity.IPlayer
import com.dkellycollins.triggerfinger.data.entity.ITimer
import com.dkellycollins.triggerfinger.managers.entity.IEnemyEntityManager
import com.dkellycollins.triggerfinger.managers.entity.IPlayerEntityManager
import com.dkellycollins.triggerfinger.managers.entity.ITimerEntityManager
import com.dkellycollins.triggerfinger.managers.events.IEventInterceptor
import com.dkellycollins.triggerfinger.managers.events.IEvent
import com.dkellycollins.triggerfinger.managers.events.impl.events.CollisionEvent

class PlayerEnemyCollisionInterceptor(private val _playerManager: IPlayerEntityManager, private val _enemyManager: IEnemyEntityManager, private val _timerManager: ITimerEntityManager) : IEventInterceptor {

    override fun handlesMessage(event: IEvent): Boolean {
        return event is CollisionEvent
    }

    override fun invoke(event: IEvent) {
        val m = event as CollisionEvent

        val player = getPlayer(m.item1, m.item2)
        val enemy = getEnemy(m.item1, m.item2)

        if (player != null && enemy != null) {
            onCollision(player, enemy)
        }
    }

    fun onCollision(player: IPlayer, enemy: IEnemy) {

        val invincibleTimer = _timerManager.retrieve(player.invincibleTimerId)
        if (invincibleTimer.isRunning) {
            return
        }

        val health = (player.health - 1).toByte()

        _playerManager.update(player.id, player.score, health)
        _timerManager.reset(player.invincibleTimerId)
        _timerManager.start(player.invincibleTimerId)
        _enemyManager.delete(enemy.id)
    }

    private fun getPlayer(item1: Int, item2: Int): IPlayer? {
        val player = _playerManager.retrievePlayerOne()

        if (player.collidableId == item1 || player.collidableId == item2) {
            return player
        }
        return null
    }

    private fun getEnemy(item1: Int, item2: Int): IEnemy? {
        var enemy: IEnemy? = _enemyManager.retrieveByCollidable(item1)
        if (enemy == null) {
            enemy = _enemyManager.retrieveByCollidable(item2)
        }

        return enemy
    }
}
