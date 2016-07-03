package com.dkellycollins.triggerfinger.data.entity

import com.dkellycollins.triggerfinger.data.model.IVector

interface IBullet : IEntity {

    val collidableId: Int

    val velocity: IVector

}
