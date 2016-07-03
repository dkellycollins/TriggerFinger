package com.dkellycollins.triggerfinger.data.config.impl

import android.content.Context

import com.dkellycollins.triggerfinger.R
import com.dkellycollins.triggerfinger.data.config.IBulletConfig
import com.dkellycollins.triggerfinger.data.model.IVector
import com.dkellycollins.triggerfinger.data.model.impl.Vector2

class BulletConfig(context: Context) : RConfig(context), IBulletConfig {


    override val collidableRadius: Float
        get() = getFloat(R.integer.bullet_collidable_radius)

    override val velocity: IVector
        get() {
            val dX = getFloat(R.integer.bullet_velocity_x)
            val dY = getFloat(R.integer.bullet_velocity_y)
            val length = getFloat(R.integer.bullet_velocity_length)

            return Vector2(dX, dY, length)
        }

    override val respawnRate: Int
        get() = _context.resources.getInteger(R.integer.bullet_respawn_rate)

    override val bitmapId: Int
        get() = R.drawable.bullet_bitmap
}
