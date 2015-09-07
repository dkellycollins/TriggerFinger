package com.dkellycollins.triggerfinger.managers.entity;

import com.dkellycollins.triggerfinger.data.entity.IBullet;
import com.dkellycollins.triggerfinger.data.model.IVector;

/**
 * Created by Devin on 9/6/2015.
 */
public interface IBulletEntityManager {

    Iterable<IBullet> retrieve();
    IBullet retrieve(int id);

    int create(IVector startingPosition);

    void delete(int id);

}
