package com.dkellycollins.triggerfinger.data.entity.impl;

import com.dkellycollins.triggerfinger.data.entity.ICollidable;
import com.dkellycollins.triggerfinger.data.model.IVector;
import com.dkellycollins.triggerfinger.data.model.impl.Vector2;
import com.dkellycollins.triggerfinger.util.qa.Assert;

import java.io.Serializable;

public class Collidable implements ICollidable, Serializable {

    private final int _id;

    private Vector2 _position;
    private float _radius;

    public Collidable(int id, IVector position, float radius) {
        Assert.isNotNull(position, "position");

        _id = id;
        _position = new Vector2(position.getX(), position.getY(), 0);
        _radius = radius;
    }

    @Override
    public IVector getCenter() {
        return _position;
    }

    @Override
    public float getRadius() {
        return _radius;
    }

    @Override
    public int getId() {
        return _id;
    }

    public void setCenter(IVector position) {
        _position.setX(position.getX());
        _position.setY(position.getY());
    }

    public void setRadius(float radius) {
        _radius = radius;
    }
}
