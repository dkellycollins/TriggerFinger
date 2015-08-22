package com.dkellycollins.triggerfinger.managers.entity;

import com.dkellycollins.triggerfinger.entity.ICollidable;
import com.dkellycollins.triggerfinger.model.IPosition;

import java.util.List;

public interface ICollidableEntityManager extends IEntityManager {

    Iterable<ICollidable> getAll();

    ICollidable get(int id);

    int create(IPosition position, float radius);

    void update(int id, IPosition position, float radius);

    void delete(int id);

}
