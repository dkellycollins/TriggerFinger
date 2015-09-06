package com.dkellycollins.triggerfinger.data.daos;

import com.dkellycollins.triggerfinger.data.entity.IEnemy;

/**
 * Created by Devin on 9/5/2015.
 */
public interface IEnemyDao {

    int create(int collidableId);

    Iterable<IEnemy> retrieve();
    IEnemy retrieve(int id);

    void update(int id, int collidableId);

    void delete(int id);

}
