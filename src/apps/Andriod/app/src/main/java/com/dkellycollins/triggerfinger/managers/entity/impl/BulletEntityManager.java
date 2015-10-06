package com.dkellycollins.triggerfinger.managers.entity.impl;

import com.dkellycollins.triggerfinger.data.config.IBulletConfig;
import com.dkellycollins.triggerfinger.data.daos.IBulletDao;
import com.dkellycollins.triggerfinger.data.entity.IBullet;
import com.dkellycollins.triggerfinger.data.model.IVector;
import com.dkellycollins.triggerfinger.data.model.impl.Vector2;
import com.dkellycollins.triggerfinger.managers.entity.IBulletEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager;

public class BulletEntityManager implements IBulletEntityManager {

    private final IBulletDao _dao;
    private final IBulletConfig _config;
    private final ICollidableEntityManager _collidableManager;

    public BulletEntityManager(IBulletDao dao, IBulletConfig config, ICollidableEntityManager collidableManager) {
        _dao = dao;
        _config = config;
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
    public IBullet retrieveByCollidable(int collidableId) {
        for(IBullet bullet : _dao.retrieve()) {
            if(bullet.getCollidableId() == collidableId) {
                return bullet;
            }
        }

        return null;
    }

    @Override
    public int create(IVector startingPosition) {
        int collidableId = _collidableManager.create(startingPosition, _config.getCollidableRadius());
        IVector velocity = _config.getVelocity();

        return _dao.create(collidableId, velocity);
    }

    @Override
    public void delete(int id) {
        IBullet bullet = _dao.retrieve(id);

        _collidableManager.delete(bullet.getCollidableId());
        _dao.delete(id);
    }
}
