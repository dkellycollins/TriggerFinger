package com.dkellycollins.triggerfinger.data.entity.impl;

import com.dkellycollins.triggerfinger.data.entity.IBullet;
import com.dkellycollins.triggerfinger.data.model.IVector;

import java.io.Serializable;

/**
 * Created by Devin on 9/6/2015.
 */
public class Bullet implements IBullet, Serializable {

    private final int _id;
    private final int _collidableId;
    private final IVector _velocity;

    public Bullet(int id, int collidableId, IVector velocity) {
        _id = id;
        _collidableId = collidableId;
        _velocity = velocity;
    }

    @Override
    public int getCollidableId() {
        return _collidableId;
    }

    @Override
    public IVector getVelocity() {
        return _velocity;
    }

    @Override
    public int getId() {
        return _id;
    }
}
