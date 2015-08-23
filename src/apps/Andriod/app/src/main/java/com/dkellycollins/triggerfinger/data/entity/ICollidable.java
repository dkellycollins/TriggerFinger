package com.dkellycollins.triggerfinger.data.entity;

import com.dkellycollins.triggerfinger.data.model.IPosition;

public interface ICollidable extends IEntity {

    IPosition getCenter();
    float getRadius();

}
