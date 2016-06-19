package com.dkellycollins.triggerfinger.data.daos;

import com.dkellycollins.triggerfinger.data.entity.IEnemy;

/**
 * Provides the ability to manage enemy data.
 */
public interface IEnemyDao extends IActivityDao {

    int create(int collidableId);

    Iterable<IEnemy> retrieve();
    IEnemy retrieve(int id);

    void update(int id, int collidableId);

    void delete(int id);

}
