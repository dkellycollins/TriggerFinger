package com.dkellycollins.triggerfinger.managers.state.impl;

import com.dkellycollins.triggerfinger.data.entity.ICollidable;
import com.dkellycollins.triggerfinger.data.entity.IEnemy;
import com.dkellycollins.triggerfinger.data.model.impl.Vector2;
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IEnemyEntityManager;
import com.dkellycollins.triggerfinger.managers.state.IStateManager;

/**
 * Created by Devin on 9/5/2015.
 */
public class EnemyStateManager implements IStateManager {

    private final IEnemyEntityManager _enemyManager;
    private final ICollidableEntityManager _collidableManager;

    public EnemyStateManager(IEnemyEntityManager enemyManager, ICollidableEntityManager collidableManager) {
        _enemyManager = enemyManager;
        _collidableManager = collidableManager;
    }

    @Override
    public void init() {
        for(int i = 1; i <= 5; i++) {
            _enemyManager.create(new Vector2(150 * i, 60, 0));
        }
    }

    @Override
    public void update(long deltaTime) {
        for(IEnemy enemy : _enemyManager.retrieve()) {
            ICollidable position = _collidableManager.retrieve(enemy.getCollidableId());

            _collidableManager.update(position.getId(), new Vector2(position.getCenter().getX(), position.getCenter().getY() + 1, 0), position.getRadius());
        }
    }
}