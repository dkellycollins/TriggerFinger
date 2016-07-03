package com.dkellycollins.triggerfinger.data.entity.impl

import com.dkellycollins.triggerfinger.data.entity.IEnemy

import java.io.Serializable

data class Enemy(override val id: Int, override var collidableId: Int) : IEnemy, Serializable
