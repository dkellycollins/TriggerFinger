package com.dkellycollins.triggerfinger.data.daos;

import com.dkellycollins.triggerfinger.data.model.IPosition;

public interface ITouchPositionDao {
    IPosition getLastPosition();
}
