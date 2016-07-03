package com.dkellycollins.triggerfinger.data.daos.impl

import com.dkellycollins.triggerfinger.data.daos.IWeaponDao
import com.dkellycollins.triggerfinger.data.entity.IWeapon
import com.dkellycollins.triggerfinger.data.entity.impl.Weapon

import java.util.HashMap

/**
 * Created by Devin on 9/6/2015.
 */
class WeaponDao : BaseEntityDao<Weapon>("WeaponDao"), IWeaponDao {

    override fun retrieve(): Iterable<IWeapon> {
        return _store.values
    }

    override fun retrieve(id: Int): IWeapon {
        return _store[id]
    }

    override fun create(collidableId: Int, timerId: Int): Int {
        val id = nextId
        val weapon = Weapon(id, collidableId, timerId)

        _store.put(id, weapon)

        return id
    }

    override fun delete(id: Int) {
        _store.remove(id)
    }
}
