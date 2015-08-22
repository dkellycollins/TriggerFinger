package com.dkellycollins.triggerfinger.managers.entity.impl;

import com.dkellycollins.triggerfinger.managers.entity.IEntityManager;

public abstract class BaseEntityManager implements IEntityManager {

    private static int COUNTER = 0;

    protected int getNextId() {
        return COUNTER++;
    }
}
