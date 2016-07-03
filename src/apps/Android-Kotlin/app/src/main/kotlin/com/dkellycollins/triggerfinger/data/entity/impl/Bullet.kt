package com.dkellycollins.triggerfinger.data.entity.impl

import com.dkellycollins.triggerfinger.data.entity.IBullet
import com.dkellycollins.triggerfinger.data.model.IVector

import java.io.Serializable

data class Bullet(override val id: Int, override val collidableId: Int, override val velocity: IVector) : IBullet, Serializable
