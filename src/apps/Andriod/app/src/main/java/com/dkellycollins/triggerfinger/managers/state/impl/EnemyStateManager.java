package com.dkellycollins.triggerfinger.managers.state.impl;

import com.dkellycollins.triggerfinger.data.daos.IDeviceInfoDao;
import com.dkellycollins.triggerfinger.data.entity.ICollidable;
import com.dkellycollins.triggerfinger.data.entity.IEnemy;
import com.dkellycollins.triggerfinger.data.entity.ITimer;
import com.dkellycollins.triggerfinger.data.model.impl.Vector2;
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IEnemyEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.ITimerEntityManager;
import com.dkellycollins.triggerfinger.managers.state.IStateManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Devin on 9/5/2015.
 */
public class EnemyStateManager implements IStateManager {

    private final IEnemyEntityManager _enemyManager;
    private final ICollidableEntityManager _collidableManager;
    private final ITimerEntityManager _timerManager;
    private final IDeviceInfoDao _deviceDao;
    private final Random _random;

    private int _timerId;
    private List<Integer> _toDelete;

    public EnemyStateManager(IEnemyEntityManager enemyManager, ICollidableEntityManager collidableManager, ITimerEntityManager timerManager, IDeviceInfoDao deviceDao, Random random) {
        _enemyManager = enemyManager;
        _collidableManager = collidableManager;
        _timerManager = timerManager;
        _deviceDao = deviceDao;
        _random = random;

        _toDelete = new ArrayList<>();
    }

    @Override
    public void init() {
        _timerId = _timerManager.create(10000, true);
        createEnemy();
    }

    @Override
    public void update(long deltaTime) {
        ITimer timer = _timerManager.retrieve(_timerId);

        if(timer.getCurrentTime() == 0) {
            createEnemy();
            _timerManager.reset(_timerId);
        }

        for(IEnemy enemy : _enemyManager.retrieve()) {
            ICollidable position = _collidableManager.retrieve(enemy.getCollidableId());

            if(position.getCenter().getY() > _deviceDao.getHeight()) {
                _toDelete.add(enemy.getId());
            }
            else {
                _collidableManager.update(position.getId(), new Vector2(position.getCenter().getX(), position.getCenter().getY() + 10, 0), position.getRadius());
            }
        }

        for(Integer id : _toDelete) {
            _enemyManager.delete(id);
        }
        _toDelete.clear();
    }

    private void createEnemy() {
        int x = _random.nextInt(_deviceDao.getWidth());
        _enemyManager.create(new Vector2(x, 0, 0));
    }
}
