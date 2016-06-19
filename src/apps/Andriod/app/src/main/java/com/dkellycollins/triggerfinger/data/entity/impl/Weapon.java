package com.dkellycollins.triggerfinger.data.entity.impl;

import com.dkellycollins.triggerfinger.data.entity.IWeapon;

import java.io.Serializable;

public class Weapon implements IWeapon, Serializable {
    private final int _id;
    private final int _collidableId;
    private final int _timerId;

    public Weapon(int id, int collidableId, int timerId) {
        _id = id;
        _collidableId = collidableId;
        _timerId = timerId;
    }

    @Override
    public int getCollidableId() {
        return _collidableId;
    }

    @Override
    public int getTimerId() {
        return _timerId;
    }

    @Override
    public int getId() {
        return _id;
    }
}
