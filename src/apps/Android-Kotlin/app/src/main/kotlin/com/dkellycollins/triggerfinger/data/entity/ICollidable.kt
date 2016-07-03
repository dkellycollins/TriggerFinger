package com.dkellycollins.triggerfinger.data.entity

import com.dkellycollins.triggerfinger.data.model.IVector

interface ICollidable : IEntity {

    val center: IVector
    val radius: Float

}
