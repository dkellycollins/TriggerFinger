package com.dkellycollins.triggerfinger.daos.impl;

import com.dkellycollins.triggerfinger.daos.IEntityDao;
import com.dkellycollins.triggerfinger.entity.IEntity;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityDao<T extends IEntity> implements IEntityDao<T> {

    private final Map<Integer, T> _store;

    public EntityDao() {
        _store = new HashMap<Integer, T>();
    }

    @Override
    public Iterable<T> getAll() {
        return _store.values();
    }

    @Override
    public T get(int id) {
        if(!_store.containsKey(id)) {
            throw new RuntimeException(String.format("Key {0} not found", id));
        }

        return _store.get(id);
    }

    @Override
    public int create(T toCreate) {
        int id = toCreate.getId();

        if(_store.containsKey(id)) {
           throw new RuntimeException(String.format("Key {0} already exists", id));
        }

        _store.put(id, toCreate);
        return id;
    }

    @Override
    public void delete(int id) {
        if(!_store.containsKey(id)) {
            throw new RuntimeException(String.format("Key {0} not found", id));
        }

        _store.remove(id);
    }
}