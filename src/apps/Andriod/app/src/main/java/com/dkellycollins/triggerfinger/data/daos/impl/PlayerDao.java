package com.dkellycollins.triggerfinger.data.daos.impl;

import com.dkellycollins.triggerfinger.data.daos.IPlayerDao;
import com.dkellycollins.triggerfinger.data.entity.IPlayer;
import com.dkellycollins.triggerfinger.data.entity.impl.Player;

import java.util.HashMap;

public class PlayerDao extends BaseEntityDao<Player> implements IPlayerDao {

    private Player _playerOne;

    public PlayerDao() {
        super("PlayerDao");
    }

    @Override
    public int create(int collidableId, int invincibleTimerId, int weaponId, int score, byte health) {
        int id = getNextId();
        Player player = new Player(id, collidableId, invincibleTimerId, weaponId, score, health);

        _store.put(id, player);
        if(_playerOne == null) {
            _playerOne = player;
        }

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
    public IPlayer playerOne() {
        return _playerOne;
    }

    @Override
    public void update(int id, int weaponId, int score, byte health) {
        if(!_store.containsKey(id)) {
            throw new RuntimeException(String.format("Key {0} not found", id));
        }

        Player player = _store.get(id);

        player.setWeaponId(weaponId);
        player.setScore(score);
        player.setHealth(health);
    }

    @Override
    public void delete(int id) {
        if(!_store.containsKey(id)) {
            throw new RuntimeException(String.format("Key {0} not found", id));
        }

        _store.remove(id);
        if(_playerOne.getId() == id) {
            _playerOne = null;
        }
    }
}
