package com.dkellycollins.triggerfinger.data.daos;

import com.dkellycollins.triggerfinger.data.entity.ICollidable;
import com.dkellycollins.triggerfinger.data.model.IVector;

public interface ICollidableDao {

    Iterable<ICollidable> retrieve();
    ICollidable retrieve(int id);

    int create(IVector position, float radius);

    void update(int id, IVector position, float radius);

    void delete(int id);

}
