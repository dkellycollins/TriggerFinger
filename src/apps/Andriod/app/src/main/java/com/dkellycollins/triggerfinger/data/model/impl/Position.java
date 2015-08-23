package com.dkellycollins.triggerfinger.data.model.impl;

import com.dkellycollins.triggerfinger.data.model.IPosition;

public class Position implements IPosition {

    private float _x;
    private float _y;

    public Position(float x, float y) {
        _x = x;
        _y = y;
    }

    @Override
    public float getX() {
        return _x;
    }

    @Override
    public float getY() {
        return _y;
    }

    public void setX(float x) {
        _x = x;
    }

    public void setY(float y) {
        _y = y;
    }
}
