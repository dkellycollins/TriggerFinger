package com.dkellycollins.triggerfinger.managers.entity;

import com.dkellycollins.triggerfinger.data.entity.ICollidable;
import com.dkellycollins.triggerfinger.data.model.IVector;

public interface ICollidableEntityManager extends IEntityManager {

    Iterable<ICollidable> retrieve();

    ICollidable retrieve(int id);

    int create(IVector position, float radius);

    void update(int id, IVector position, float radius);

    void delete(int id);

}
