package com.dkellycollins.triggerfinger.managers.entity.impl;

import com.dkellycollins.triggerfinger.data.daos.IBulletDao;
import com.dkellycollins.triggerfinger.data.entity.IBullet;
import com.dkellycollins.triggerfinger.data.model.IVector;
import com.dkellycollins.triggerfinger.data.model.impl.Vector2;
import com.dkellycollins.triggerfinger.managers.entity.IBulletEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager;

/**
 * Created by Devin on 9/6/2015.
 */
public class BulletEntityManager implements IBulletEntityManager {

    private final IBulletDao _dao;
    private final ICollidableEntityManager _collidableManager;

    public BulletEntityManager(IBulletDao dao, ICollidableEntityManager collidableManager) {
        _dao = dao;
        _collidableManager = collidableManager;
    }

    @Override
    public Iterable<IBullet> retrieve() {
        return _dao.retrieve();
    }

    @Override
    public IBullet retrieve(int id) {
        return _dao.retrieve(id);
    }

    @Override
    public int create(IVector startingPosition) {
        int collidableId = _collidableManager.create(startingPosition, 20);
        IVector velocity = new Vector2(0, -10, 1);

        return _dao.create(collidableId, velocity);
    }

    @Override
    public void delete(int id) {
        IBullet bullet = _dao.retrieve(id);

        _collidableManager.delete(bullet.getCollidableId());
        _dao.delete(id);
    }
}
