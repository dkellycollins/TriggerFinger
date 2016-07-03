package com.dkellycollins.triggerfinger.managers.entity

import com.dkellycollins.triggerfinger.data.entity.IWeapon

interface IWeaponEntityManager {

    fun retrieve(): Iterable<IWeapon>
    fun retrieve(id: Int): IWeapon

    fun create(collidableId: Int): Int

    fun delete(id: Int)

}
