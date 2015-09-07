package com.dkellycollins.triggerfinger.data.config.impl;

import android.content.Context;

import com.dkellycollins.triggerfinger.R;
import com.dkellycollins.triggerfinger.data.config.IPlayerConfig;

public class PlayerConfig extends RConfig implements IPlayerConfig {

    public PlayerConfig(Context context) {
        super(context);
    }

    @Override
    public int getBitmapId() {
        return R.drawable.player_bitmap;
    }

    @Override
    public float getCollidableRadius() {
        return getFloat(R.integer.player_collidable_radius);
    }
}
