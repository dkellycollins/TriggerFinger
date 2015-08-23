package com.dkellycollins.triggerfinger.data.daos;

import com.dkellycollins.triggerfinger.data.entity.ICollidable;
import com.dkellycollins.triggerfinger.data.model.IPosition;

public interface ICollidableDao {

    Iterable<ICollidable> retrieve();
    ICollidable retrieve(int id);

    int create(IPosition position, float radius);

    void update(int id, IPosition position, float radius);

    void delete(int id);

}
