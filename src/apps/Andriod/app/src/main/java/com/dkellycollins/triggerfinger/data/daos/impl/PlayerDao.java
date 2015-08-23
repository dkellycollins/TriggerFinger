package com.dkellycollins.triggerfinger.data.daos.impl;

import com.dkellycollins.triggerfinger.data.daos.IPlayerDao;
import com.dkellycollins.triggerfinger.data.entity.IPlayer;
import com.dkellycollins.triggerfinger.data.entity.impl.Player;

import java.util.HashMap;

public class PlayerDao extends BaseEntityDao implements IPlayerDao {

    private final HashMap<Integer, Player> _store;

    public PlayerDao() {
        _store = new HashMap<>();
    }

    @Override
    public int create(int collidableId) {
        int id = getNextId();
        Player player = new Player(id, collidableId);

        _store.put(id, player);

        return id;
    }

    @Override
    public Iterable<IPlayer> retrieve() {
        return (Iterable<IPlayer>) (Iterable<?>) _store.values();
    }

    @Override
    public IPlayer retrieve(int id) {
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

        Player player = _store.get(id);
        player.setCollidableId(collidableId);
    }

    @Override
    public void delete(int id) {
        if(!_store.containsKey(id)) {
            throw new RuntimeException(String.format("Key {0} not found", id));
        }

        _store.remove(id);
    }
}
