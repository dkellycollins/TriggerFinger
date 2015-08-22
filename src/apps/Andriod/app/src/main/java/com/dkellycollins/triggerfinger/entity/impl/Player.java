package com.dkellycollins.triggerfinger.entity.impl;

import com.dkellycollins.triggerfinger.entity.IPlayer;

public class Player implements IPlayer {

    private final int _id;

    private int _collidableId;

    public Player(int id, int collidableId) {
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
