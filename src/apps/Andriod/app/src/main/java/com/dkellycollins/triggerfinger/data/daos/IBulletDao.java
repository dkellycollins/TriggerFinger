package com.dkellycollins.triggerfinger.data.daos;

import com.dkellycollins.triggerfinger.data.daos.impl.BaseEntityDao;
import com.dkellycollins.triggerfinger.data.entity.IBullet;
import com.dkellycollins.triggerfinger.data.model.IVector;

/**
 * Created by Devin on 9/6/2015.
 */
public interface IBulletDao {

    Iterable<IBullet> retrieve();
    IBullet retrieve(int id);

    int create(int collidableId, IVector velocity);

    void delete(int id);

}
