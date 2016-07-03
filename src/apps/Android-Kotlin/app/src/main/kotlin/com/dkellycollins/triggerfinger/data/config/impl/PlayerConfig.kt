package com.dkellycollins.triggerfinger.data.config.impl

import android.content.Context

import com.dkellycollins.triggerfinger.R
import com.dkellycollins.triggerfinger.data.config.IPlayerConfig

class PlayerConfig(context: Context) : RConfig(context), IPlayerConfig {

    override val bitmapId: Int
        get() = R.drawable.player_bitmap

    override val collidableRadius: Float
        get() = getFloat(R.integer.player_collidable_radius)

    override val invincibleTime: Int
        get() = _context.resources.getInteger(R.integer.player_invincible_time)
}
