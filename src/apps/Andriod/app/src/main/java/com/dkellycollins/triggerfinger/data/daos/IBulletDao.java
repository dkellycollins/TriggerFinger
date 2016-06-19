package com.dkellycollins.triggerfinger.data.daos;

import com.dkellycollins.triggerfinger.data.entity.IBullet;
import com.dkellycollins.triggerfinger.data.model.IVector;

/**
 * Provides the ability to manage bullet data.
 */
public interface IBulletDao extends IActivityDao {

    Iterable<IBullet> retrieve();
    IBullet retrieve(int id);

    int create(int collidableId, IVector velocity);

    void delete(int id);

}
