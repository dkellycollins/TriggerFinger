package com.dkellycollins.triggerfinger.data.daos;

import com.dkellycollins.triggerfinger.data.model.IVector;

/**
 * Provides the ability to retrieve touch data.
 */
public interface ITouchPositionDao {
    IVector getLastPosition();
    boolean isTouching();
}
