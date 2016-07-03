package com.dkellycollins.triggerfinger.data.entity.impl

import com.dkellycollins.triggerfinger.data.entity.IPlayer

import java.io.Serializable

class Player(override val id: Int, override val collidableId: Int, override val invincibleTimerId: Int, override var weaponId: Int, override var score: Int, health: Byte) : IPlayer, Serializable {
    override var health: Byte = 0
        get() = 0

    init {
        this.health = health
    }
}
