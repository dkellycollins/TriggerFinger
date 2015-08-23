package com.dkellycollins.triggerfinger.data.entity.impl;

import com.dkellycollins.triggerfinger.data.entity.ICollidable;
import com.dkellycollins.triggerfinger.data.model.IPosition;
import com.dkellycollins.triggerfinger.data.model.impl.Position;

public class Collidable implements ICollidable {

    private final int _id;

    private Position _position;
    private float _radius;

    public Collidable(int id, IPosition position, float radius) {
        _id = id;

        _position = new Position(position.getX(), position.getY());
        _radius = radius;
    }

    @Override
    public IPosition getCenter() {
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

    public void setCenter(IPosition position) {
        _position.setX(position.getX());
        _position.setY(position.getY());
    }

    public void setRadius(float radius) {
        _radius = radius;
    }
}
