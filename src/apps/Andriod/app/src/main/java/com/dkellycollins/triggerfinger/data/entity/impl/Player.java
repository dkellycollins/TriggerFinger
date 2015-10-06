package com.dkellycollins.triggerfinger.data.entity.impl;

import com.dkellycollins.triggerfinger.data.entity.IPlayer;

public class Player implements IPlayer {

    private final int _id;
    private final int _collidableId;

    private int _weaponId;
    private int _score;

    public Player(int id, int collidableId, int weaponId, int score) {
        _id = id;
        _collidableId = collidableId;
        _weaponId = weaponId;
        _score = score;
    }

    @Override
    public int getCollidableId() {
        return _collidableId;
    }

    @Override
    public int getWeaponId() {
        return _weaponId;
    }

    @Override
    public int getScore() {
        return _score;
    }

    @Override
    public int getId() {
        return _id;
    }

    public void setWeaponId(int weaponId) {
        _weaponId = weaponId;
    }

    public void setScore(int score) {
        _score = score;
    }
}
