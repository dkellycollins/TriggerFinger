package com.dkellycollins.triggerfinger.data.entity;

import com.dkellycollins.triggerfinger.data.model.IVector;

public interface IBullet extends IEntity {

    int getCollidableId();

    IVector getVelocity();

}
