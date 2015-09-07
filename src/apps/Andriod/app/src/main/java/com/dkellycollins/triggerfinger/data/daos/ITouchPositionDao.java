package com.dkellycollins.triggerfinger.data.daos;

import com.dkellycollins.triggerfinger.data.model.IVector;

public interface ITouchPositionDao {
    IVector getLastPosition();
    boolean isTouching();
}
