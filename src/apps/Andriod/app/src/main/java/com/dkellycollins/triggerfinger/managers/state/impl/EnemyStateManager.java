package com.dkellycollins.triggerfinger.managers.state.impl;

import com.dkellycollins.triggerfinger.data.entity.ICollidable;
import com.dkellycollins.triggerfinger.data.entity.IEnemy;
import com.dkellycollins.triggerfinger.data.entity.ITimer;
import com.dkellycollins.triggerfinger.data.model.impl.Vector2;
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IEnemyEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.ITimerEntityManager;
import com.dkellycollins.triggerfinger.managers.state.IStateManager;

/**
 * Created by Devin on 9/5/2015.
 */
public class EnemyStateManager implements IStateManager {

    private final IEnemyEntityManager _enemyManager;
    private final ICollidableEntityManager _collidableManager;
    private final ITimerEntityManager _timerManager;

    private int _timerId;

    public EnemyStateManager(IEnemyEntityManager enemyManager, ICollidableEntityManager collidableManager, ITimerEntityManager timerManager) {
        _enemyManager = enemyManager;
        _collidableManager = collidableManager;
        _timerManager = timerManager;
    }

    @Override
    public void init() {
        _timerId = _timerManager.create(10000);
        _enemyManager.create(new Vector2(100, 100, 0));
    }

    @Override
    public void update(long deltaTime) {
        ITimer timer = _timerManager.retrieve(_timerId);

        if(timer.getCurrentTime() == 0) {
            _enemyManager.create(new Vector2(100, 100, 0));
            _timerManager.reset(_timerId);
        }

        for(IEnemy enemy : _enemyManager.retrieve()) {
            ICollidable position = _collidableManager.retrieve(enemy.getCollidableId());

            _collidableManager.update(position.getId(), new Vector2(position.getCenter().getX(), position.getCenter().getY() + 10, 0), position.getRadius());
        }
    }
}
