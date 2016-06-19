package com.dkellycollins.triggerfinger.data.daos.impl;

import android.os.Bundle;

import com.dkellycollins.triggerfinger.data.daos.IBulletDao;
import com.dkellycollins.triggerfinger.data.entity.IBullet;
import com.dkellycollins.triggerfinger.data.entity.impl.Bullet;
import com.dkellycollins.triggerfinger.data.model.IVector;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Standard implementation of IBulletDao.
 */
public class BulletDao extends BaseEntityDao<Bullet> implements IBulletDao {

    public BulletDao() {
        super("BulletDao");
    }

    @Override
    public Iterable<IBullet> retrieve() {
        return (Iterable<IBullet>) (Iterable<?>) _store.values();
    }

    @Override
    public IBullet retrieve(int id) {
        return _store.get(id);
    }

    @Override
    public int create(int collidableId, IVector velocity) {
        int id = getNextId();
        Bullet bullet = new Bullet(id, collidableId, velocity);

        _store.put(id, bullet);

        return id;
    }

    @Override
    public void delete(int id) {
        _store.remove(id);
    }
}