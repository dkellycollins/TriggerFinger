package com.dkellycollins.triggerfinger.managers.entity;

import com.dkellycollins.triggerfinger.data.entity.IEnemy;
import com.dkellycollins.triggerfinger.data.model.IVector;

public interface IEnemyEntityManager {

    Iterable<IEnemy> retrieve();
    IEnemy retrieve(int enemyId);
    IEnemy retrieveByCollidable(int collidableId);

    int create(IVector position);

    void delete(int playerId);

}
