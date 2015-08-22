package com.dkellycollins.triggerfinger.entity;

import com.dkellycollins.triggerfinger.model.IPosition;

public interface ICollidable extends IEntity {

    IPosition getCenter();
    float getRadius();

}
