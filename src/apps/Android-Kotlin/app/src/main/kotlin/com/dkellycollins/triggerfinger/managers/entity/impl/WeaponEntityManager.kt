package com.dkellycollins.triggerfinger.managers.entity.impl

import com.dkellycollins.triggerfinger.data.config.IBulletConfig
import com.dkellycollins.triggerfinger.data.daos.IWeaponDao
import com.dkellycollins.triggerfinger.data.entity.IWeapon
import com.dkellycollins.triggerfinger.managers.entity.ITimerEntityManager
import com.dkellycollins.triggerfinger.managers.entity.IWeaponEntityManager

class WeaponEntityManager(private val _dao: IWeaponDao, private val _bulletConfig: IBulletConfig, private val _timerManager: ITimerEntityManager) : IWeaponEntityManager {

    override fun retrieve(): Iterable<IWeapon> {
        return _dao.retrieve()
    }

    override fun retrieve(id: Int): IWeapon {
        return _dao.retrieve(id)
    }

    override fun create(collidableId: Int): Int {
        val timerId = _timerManager.create(_bulletConfig.respawnRate, true)
        val weaponId = _dao.create(collidableId, timerId)

        return weaponId
    }

    override fun delete(id: Int) {
        val weapon = _dao.retrieve(id)

        _timerManager.delete(weapon.timerId)
        _dao.delete(weapon.id)
    }
}
