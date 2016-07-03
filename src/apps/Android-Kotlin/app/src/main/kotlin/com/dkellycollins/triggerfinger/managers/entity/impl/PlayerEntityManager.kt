package com.dkellycollins.triggerfinger.managers.entity.impl

import com.dkellycollins.triggerfinger.data.config.IPlayerConfig
import com.dkellycollins.triggerfinger.data.daos.IPlayerDao
import com.dkellycollins.triggerfinger.data.entity.IPlayer
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager
import com.dkellycollins.triggerfinger.managers.entity.IPlayerEntityManager
import com.dkellycollins.triggerfinger.data.model.IVector
import com.dkellycollins.triggerfinger.managers.entity.ITimerEntityManager
import com.dkellycollins.triggerfinger.managers.entity.IWeaponEntityManager

class PlayerEntityManager(private val _dao: IPlayerDao, private val _config: IPlayerConfig, private val _collidableManager: ICollidableEntityManager, private val _weaponManager: IWeaponEntityManager, private val _timerManager: ITimerEntityManager) : IPlayerEntityManager {

    override fun retrieve(): Iterable<IPlayer> {
        return _dao.retrieve()
    }

    override fun retrieve(playerId: Int): IPlayer {
        return _dao.retrieve(playerId)
    }

    override fun retrievePlayerOne(): IPlayer {
        return _dao.playerOne()
    }

    override fun create(position: IVector): Int {
        val collidableId = _collidableManager.create(position, _config.collidableRadius)
        val weaponId = _weaponManager.create(collidableId)
        val invincibleTimerId = _timerManager.create(_config.invincibleTime, false)

        return _dao.create(collidableId, weaponId, invincibleTimerId, 0, 3.toByte())
    }

    override fun update(playerId: Int, score: Int, health: Byte) {
        val player = _dao.retrieve(playerId)

        _dao.update(playerId, player.weaponId, score, health)
    }

    override fun delete(playerId: Int) {
        val player = _dao.retrieve(playerId)
        _dao.delete(playerId)
        _collidableManager.delete(player.collidableId)
    }
}
