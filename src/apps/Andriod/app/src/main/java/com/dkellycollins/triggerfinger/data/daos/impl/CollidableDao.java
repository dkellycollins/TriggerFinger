package com.dkellycollins.triggerfinger.data.daos.impl;

import android.os.Bundle;

import com.dkellycollins.triggerfinger.data.daos.ICollidableDao;
import com.dkellycollins.triggerfinger.data.entity.ICollidable;
import com.dkellycollins.triggerfinger.data.entity.impl.Bullet;
import com.dkellycollins.triggerfinger.data.entity.impl.Collidable;
import com.dkellycollins.triggerfinger.data.model.IVector;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CollidableDao extends BaseEntityDao<Collidable> implements ICollidableDao {

    public CollidableDao() {
        super("CollidableDao");
    }

    @Override
    public Iterable<ICollidable> retrieve() {
        return (Iterable<ICollidable>) (Iterable<?>) _store.values();
    }

    @Override
    public ICollidable retrieve(int id) {
        if(!_store.containsKey(id)) {
            throw new RuntimeException(String.format("Key {0} not found", id));
        }

        return _store.get(id);
    }

    @Override
    public int create(IVector position, float radius) {
        int id = getNextId();
        Collidable collidable = new Collidable(id, position, radius);

        _store.put(id, collidable);

        return id;
    }

    @Override
    public void update(int id, IVector position, float radius) {
        if(!_store.containsKey(id)) {
            throw new RuntimeException(String.format("Key {0} not found", id));
        }

        Collidable collidable = _store.get(id);
        collidable.setCenter(position);
        collidable.setRadius(radius);
    }

    @Override
    public void delete(int id) {
        if(!_store.containsKey(id)) {
            throw new RuntimeException(String.format("Key {0} not found", id));
        }

        _store.remove(id);
    }
}
