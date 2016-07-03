package com.dkellycollins.triggerfinger.data.config.impl

import android.content.Context

import com.dkellycollins.triggerfinger.R
import com.dkellycollins.triggerfinger.data.config.IEnemyConfig

class EnemyConfig(context: Context) : RConfig(context), IEnemyConfig {

    override val spriteId: Int
        get() = R.drawable.enemy_sprite

    override val respawnRate: Int
        get() = _context.resources.getInteger(R.integer.enemy_respawn_rate)

    override val collidableRadius: Float
        get() = getFloat(R.integer.enemy_collidable_radius)

    override val deltaY: Float
        get() = getFloat(R.integer.enemy_delta_y)
}
