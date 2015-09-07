package com.dkellycollins.triggerfinger.data.daos.impl;

import com.dkellycollins.triggerfinger.data.daos.IBulletDao;
import com.dkellycollins.triggerfinger.data.entity.IBullet;
import com.dkellycollins.triggerfinger.data.entity.impl.Bullet;
import com.dkellycollins.triggerfinger.data.model.IVector;

import java.util.HashMap;

/**
 * Created by Devin on 9/6/2015.
 */
public class BulletDao extends BaseEntityDao implements IBulletDao {

    private final HashMap<Integer, Bullet> _store;

    public BulletDao() {
        _store = new HashMap<>();
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
