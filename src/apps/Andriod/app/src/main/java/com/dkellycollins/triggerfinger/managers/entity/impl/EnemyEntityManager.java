package com.dkellycollins.triggerfinger.managers.entity.impl;

import com.dkellycollins.triggerfinger.data.config.IEnemyConfig;
import com.dkellycollins.triggerfinger.data.daos.IEnemyDao;
import com.dkellycollins.triggerfinger.data.entity.IEnemy;
import com.dkellycollins.triggerfinger.data.model.IVector;
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IEnemyEntityManager;

public class EnemyEntityManager implements IEnemyEntityManager {

    private final IEnemyDao _dao;
    private final IEnemyConfig _config;
    private final ICollidableEntityManager _collidableManager;

    public EnemyEntityManager(IEnemyDao dao, IEnemyConfig config, ICollidableEntityManager collidableManager) {
        _dao = dao;
        _config = config;
        _collidableManager = collidableManager;
    }

    @Override
    public Iterable<IEnemy> retrieve() {
        return _dao.retrieve();
    }

    @Override
    public IEnemy retrieve(int id) {
        return _dao.retrieve(id);
    }

    @Override
    public IEnemy retrieveByCollidable(int collidableId) {
        for(IEnemy enemy : _dao.retrieve()) {
            if(enemy.getCollidableId() == collidableId) {
                return enemy;
            }
        }

        return null;
    }

    @Override
    public int create(IVector position) {
        int collidableId = _collidableManager.create(position, _config.getCollidableRadius());
        return _dao.create(collidableId);
    }

    @Override
    public void delete(int id) {
        IEnemy enemy = _dao.retrieve(id);
        _dao.delete(id);
        _collidableManager.delete(enemy.getCollidableId());
    }
}
