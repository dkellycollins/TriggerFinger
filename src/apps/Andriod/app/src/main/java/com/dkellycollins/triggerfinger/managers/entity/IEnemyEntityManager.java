package com.dkellycollins.triggerfinger.managers.entity;

import com.dkellycollins.triggerfinger.data.entity.IEnemy;
import com.dkellycollins.triggerfinger.data.model.IVector;

public interface IEnemyEntityManager {

    Iterable<IEnemy> retrieve();

    IEnemy get(int playerId);

    int create(IVector position);

    void delete(int playerId);

}
