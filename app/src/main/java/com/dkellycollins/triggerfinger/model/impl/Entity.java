package com.dkellycollins.triggerfinger.model.impl;

import com.dkellycollins.triggerfinger.model.IEntity;

public class Entity implements IEntity{

    private final int _id;

    public Entity(int id) {
        _id = id;
    }

    @Override
    public int getID() {
        return _id;
    }
}
