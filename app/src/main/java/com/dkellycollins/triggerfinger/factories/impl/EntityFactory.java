package com.dkellycollins.triggerfinger.factories.impl;


import com.dkellycollins.triggerfinger.factories.IEntityFactory;
import com.dkellycollins.triggerfinger.model.IEntity;

public class EntityFactory implements IEntityFactory{

    private int _nextID;

    public EntityFactory() {

    }

    @Override
    public IEntity createEntity() {
        return null;
    }
}
