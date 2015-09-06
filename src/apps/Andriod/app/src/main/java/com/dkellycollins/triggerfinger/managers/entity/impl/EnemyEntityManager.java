package com.dkellycollins.triggerfinger.managers.entity.impl;

import com.dkellycollins.triggerfinger.data.daos.IEnemyDao;
import com.dkellycollins.triggerfinger.data.entity.IEnemy;
import com.dkellycollins.triggerfinger.data.model.IVector;
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IEnemyEntityManager;

public class EnemyEntityManager implements IEnemyEntityManager {

    private final IEnemyDao _dao;
    private final ICollidableEntityManager _collidableManager;

    public EnemyEntityManager(IEnemyDao dao, ICollidableEntityManager collidableManager) {
        _dao = dao;
        _collidableManager = collidableManager;
    }

    @Override
    public Iterable<IEnemy> retrieve() {
        return _dao.retrieve();
    }

    @Override
    public IEnemy get(int id) {
        return _dao.retrieve(id);
    }

    @Override
    public int create(IVector position) {
        int collidableId = _collidableManager.create(position, 50);
        return _dao.create(collidableId);
    }

    @Override
    public void delete(int id) {
        _dao.delete(id);
    }
}
