package com.dkellycollins.triggerfinger.data.config

import com.dkellycollins.triggerfinger.data.model.IVector

/**
 * Created by Devin on 9/7/2015.
 */
interface IBulletConfig {

    val collidableRadius: Float

    val velocity: IVector

    val respawnRate: Int

    val bitmapId: Int
}
