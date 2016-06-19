package com.dkellycollins.triggerfinger.data.entity.impl;

import com.dkellycollins.triggerfinger.data.entity.IEnemy;

import java.io.Serializable;

public class Enemy implements IEnemy, Serializable {
    private final int _id;

    private int _collidableId;

    public Enemy(int id, int collidableId) {
        _id = id;
        _collidableId = collidableId;
    }

    @Override
    public int getCollidableId() {
        return _collidableId;
    }

    @Override
    public int getId() {
        return _id;
    }

    public void setCollidableId(int collidableId) {
        _collidableId = collidableId;
    }
}
