package com.dkellycollins.triggerfinger.data.daos

import com.dkellycollins.triggerfinger.data.entity.IPlayer

interface IPlayerDao : IActivityDao {

    fun create(collidableId: Int, invincibleTimerId: Int, weaponId: Int, score: Int, health: Byte): Int

    fun retrieve(): Iterable<IPlayer>
    fun retrieve(id: Int): IPlayer
    fun playerOne(): IPlayer

    fun update(id: Int, weaponId: Int, score: Int, health: Byte)

    fun delete(id: Int)
}