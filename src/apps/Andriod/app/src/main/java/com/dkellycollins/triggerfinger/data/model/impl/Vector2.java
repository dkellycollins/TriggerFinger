package com.dkellycollins.triggerfinger.data.model.impl;

import com.dkellycollins.triggerfinger.data.model.IVector;

public class Vector2 implements IVector {

    private float _x;
    private float _y;
    private float _length;

    public Vector2() {
        _x = 0;
        _y = 0;
        _length = 0;
    }

    public Vector2(float x, float y, float length) {
        _x = x;
        _y = y;
        _length = length;
    }

    @Override
    public float getX() {
        return _x;
    }

    @Override
    public float getY() {
        return _y;
    }

    @Override
    public float getLength() {
        return _length;
    }

    public void setX(float x) {
        _x = x;
    }

    public void setY(float y) {
        _y = y;
    }

    public void setLength(float length) {
        _length = length;
    }

    @Override
    public String toString() {
        return "X: " + _x + " Y: " + _y + " Length: " + _length;
    }
}
