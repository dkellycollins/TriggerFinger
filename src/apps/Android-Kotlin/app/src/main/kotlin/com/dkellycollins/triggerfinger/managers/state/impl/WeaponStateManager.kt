package com.dkellycollins.triggerfinger.managers.state.impl

import com.dkellycollins.triggerfinger.data.entity.ICollidable
import com.dkellycollins.triggerfinger.data.entity.ITimer
import com.dkellycollins.triggerfinger.data.entity.IWeapon
import com.dkellycollins.triggerfinger.managers.entity.IBulletEntityManager
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager
import com.dkellycollins.triggerfinger.managers.entity.ITimerEntityManager
import com.dkellycollins.triggerfinger.managers.entity.IWeaponEntityManager
import com.dkellycollins.triggerfinger.managers.state.IStateManager

class WeaponStateManager(private val _weaponManager: IWeaponEntityManager, private val _timerManager: ITimerEntityManager, private val _bulletManager: IBulletEntityManager, private val _collidableManager: ICollidableEntityManager) : IStateManager {

    override fun init() {

    }

    override fun update(deltaTime: Long) {

        for (weapon in _weaponManager.retrieve()) {
            val timer = _timerManager.retrieve(weapon.timerId)

            if (timer.currentTime == 0) {
                val collidable = _collidableManager.retrieve(weapon.collidableId)
                _bulletManager.create(collidable.center)

                _timerManager.reset(weapon.timerId)
            }

        }
    }
}
