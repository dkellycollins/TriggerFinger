package com.dkellycollins.triggerfinger.data.entity.impl

import com.dkellycollins.triggerfinger.data.entity.IWeapon

import java.io.Serializable

data class Weapon(override val id: Int, override val collidableId: Int, override val timerId: Int) : IWeapon, Serializable
