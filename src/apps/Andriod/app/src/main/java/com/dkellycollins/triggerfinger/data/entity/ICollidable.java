package com.dkellycollins.triggerfinger.data.entity;

import com.dkellycollins.triggerfinger.data.model.IVector;

public interface ICollidable extends IEntity {

    IVector getCenter();
    float getRadius();

}
