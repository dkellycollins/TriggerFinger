package com.dkellycollins.triggerfinger.data.daos.impl;

public abstract class BaseEntityDao {

    private static int NEXT_ID = 0;

    protected int getNextId() {
        return NEXT_ID++;
    }

}