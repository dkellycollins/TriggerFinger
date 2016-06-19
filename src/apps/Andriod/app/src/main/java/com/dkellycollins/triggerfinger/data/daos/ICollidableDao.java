package com.dkellycollins.triggerfinger.data.daos;

import com.dkellycollins.triggerfinger.data.entity.ICollidable;
import com.dkellycollins.triggerfinger.data.model.IVector;

/**
 * Provides the ability to manage collidable data.
 */
public interface ICollidableDao extends IActivityDao {

    Iterable<ICollidable> retrieve();
    ICollidable retrieve(int id);

    int create(IVector position, float radius);

    void update(int id, IVector position, float radius);

    void delete(int id);

}
