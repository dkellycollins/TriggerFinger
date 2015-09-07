package com.dkellycollins.triggerfinger.data.config.impl;

import android.content.Context;

import com.dkellycollins.triggerfinger.R;
import com.dkellycollins.triggerfinger.data.config.IBulletConfig;
import com.dkellycollins.triggerfinger.data.model.IVector;
import com.dkellycollins.triggerfinger.data.model.impl.Vector2;

public class BulletConfig extends RConfig implements IBulletConfig {

    public BulletConfig(Context context) {
        super(context);
    }


    @Override
    public float getCollidableRadius() {
        return getFloat(R.integer.bullet_collidable_radius);
    }

    @Override
    public IVector getVelocity() {
        float dX = getFloat(R.integer.bullet_velocity_x);
        float dY = getFloat(R.integer.bullet_velocity_y);
        float length = getFloat(R.integer.bullet_velocity_length);

        return new Vector2(dX, dY, length);
    }

    @Override
    public int getRespawnRate() {
        return _context.getResources().getInteger(R.integer.bullet_respawn_rate);
    }
}
