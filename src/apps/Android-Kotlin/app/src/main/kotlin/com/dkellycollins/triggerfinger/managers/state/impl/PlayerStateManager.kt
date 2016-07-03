package com.dkellycollins.triggerfinger.managers.state.impl

import com.dkellycollins.triggerfinger.data.daos.ITouchPositionDao
import com.dkellycollins.triggerfinger.data.entity.ICollidable
import com.dkellycollins.triggerfinger.data.entity.IPlayer
import com.dkellycollins.triggerfinger.data.entity.ITimer
import com.dkellycollins.triggerfinger.data.entity.IWeapon
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager
import com.dkellycollins.triggerfinger.managers.entity.IPlayerEntityManager
import com.dkellycollins.triggerfinger.managers.entity.ITimerEntityManager
import com.dkellycollins.triggerfinger.managers.entity.IWeaponEntityManager
import com.dkellycollins.triggerfinger.managers.state.IStateManager
import com.dkellycollins.triggerfinger.data.model.IVector
import com.dkellycollins.triggerfinger.data.model.impl.Vector2

class PlayerStateManager(private val _playerManager: IPlayerEntityManager, private val _collidableManager: ICollidableEntityManager, private val _touchPositionDao: ITouchPositionDao, private val _weaponManager: IWeaponEntityManager, private val _timerEnityManager: ITimerEntityManager) : IStateManager {

    private var _playerId: Int = 0

    override fun init() {
        _playerId = _playerManager.create(Vector2())
    }

    override fun update(deltaTime: Long) {
        val player = _playerManager.retrieve(_playerId)
        val collidable = _collidableManager.retrieve(player.collidableId)
        val newPosition = _touchPositionDao.lastPosition

        _collidableManager.update(player.collidableId, newPosition, collidable.radius)

        val weapon = _weaponManager.retrieve(player.weaponId)
        val timer = _timerEnityManager.retrieve(weapon.timerId)

        val isTouching = _touchPositionDao.isTouching
        _timerEnityManager.update(timer.id, if (isTouching) timer.currentTime else 1, isTouching)
    }
}
