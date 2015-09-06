package com.dkellycollins.triggerfinger.data.daos.impl;

import com.dkellycollins.triggerfinger.data.daos.IEnemyDao;
import com.dkellycollins.triggerfinger.data.entity.IEnemy;
import com.dkellycollins.triggerfinger.data.entity.IPlayer;
import com.dkellycollins.triggerfinger.data.entity.impl.Enemy;
import com.dkellycollins.triggerfinger.data.entity.impl.Player;

import java.util.HashMap;

public class EnemyDao extends BaseEntityDao implements IEnemyDao {

    private final HashMap<Integer, Enemy> _store;

    public EnemyDao() {
        _store = new HashMap<>();
    }

    @Override
    public int create(int collidableId) {
        int id = getNextId();
        Enemy enemy = new Enemy(id, collidableId);

        _store.put(id, enemy);

        return id;
    }

    @Override
    public Iterable<IEnemy> retrieve() {
        return (Iterable<IEnemy>) (Iterable<?>) _store.values();
    }

    @Override
    public IEnemy retrieve(int id) {
        if(!_store.containsKey(id)) {
            throw new RuntimeException(String.format("Key {0} not found", id));
        }

        return _store.get(id);
    }

    @Override
    public void update(int id, int collidableId) {
        if(!_store.containsKey(id)) {
            throw new RuntimeException(String.format("Key {0} not found", id));
        }

        Enemy enemy = _store.get(id);
        enemy.setCollidableId(collidableId);
    }

    @Override
    public void delete(int id) {
        if(!_store.containsKey(id)) {
            throw new RuntimeException(String.format("Key {0} not found", id));
        }

        _store.remove(id);
    }

}
