package com.dkellycollins.triggerfinger.data.config.impl;

import android.content.Context;

import com.dkellycollins.triggerfinger.R;
import com.dkellycollins.triggerfinger.data.config.IEnemyConfig;

public class EnemyConfig extends RConfig implements IEnemyConfig {

    public EnemyConfig(Context context) {
        super(context);
    }

    @Override
    public int getRespawnRate() {
        return _context.getResources().getInteger(R.integer.enemy_respawn_rate);
    }

    @Override
    public float getCollidableRadius() {
        return getFloat(R.integer.enemy_collidable_radius);
    }

    @Override
    public float getDeltaY() {
        return getFloat(R.integer.enemy_delta_y);
    }
}
