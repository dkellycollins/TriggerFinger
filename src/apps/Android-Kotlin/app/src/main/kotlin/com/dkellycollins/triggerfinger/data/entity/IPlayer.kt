package com.dkellycollins.triggerfinger.data.entity

interface IPlayer : IEntity {

    val collidableId: Int

    val weaponId: Int

    val score: Int

    val health: Byte

    val invincibleTimerId: Int

}
