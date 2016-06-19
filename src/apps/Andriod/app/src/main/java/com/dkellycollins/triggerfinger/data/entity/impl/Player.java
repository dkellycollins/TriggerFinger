package com.dkellycollins.triggerfinger.data.entity.impl;

import com.dkellycollins.triggerfinger.data.entity.IPlayer;

import java.io.Serializable;

public class Player implements IPlayer, Serializable {

    private final int _id;
    private final int _collidableId;
    private final int _invincibleTimerId;

    private int _weaponId;
    private int _score;
    private byte _health;

    public Player(int id, int collidableId, int invincibleTimerId, int weaponId, int score, byte health) {
        _id = id;
        _collidableId = collidableId;
        _invincibleTimerId = invincibleTimerId;
        _weaponId = weaponId;
        _score = score;
        _health = health;
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
    public byte getHealth() {
        return 0;
    }

    @Override
    public int getInvincibleTimerId() {
        return _invincibleTimerId;
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

    public void setHealth(byte health) {
        _health = health;
    }
}
