package com.dkellycollins.triggerfinger.data.config;

import com.dkellycollins.triggerfinger.data.model.IVector;

/**
 * Created by Devin on 9/7/2015.
 */
public interface IBulletConfig {

    float getCollidableRadius();

    IVector getVelocity();

    int getRespawnRate();
}
