package com.dkellycollins.triggerfinger.data.daos

import com.dkellycollins.triggerfinger.data.entity.IWeapon

/**
 * Provides te ability to manage weapon data.
 */
interface IWeaponDao : IActivityDao {

    fun retrieve(): Iterable<IWeapon>
    fun retrieve(id: Int): IWeapon

    fun create(collidableId: Int, timerId: Int): Int

    fun delete(id: Int)
}
