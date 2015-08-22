package com.dkellycollins.triggerfinger.daos;

import com.dkellycollins.triggerfinger.model.IPosition;

public interface ITouchPositionDao {
    IPosition getLastPosition();
}
