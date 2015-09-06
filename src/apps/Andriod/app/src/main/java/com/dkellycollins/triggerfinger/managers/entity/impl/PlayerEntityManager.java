package com.dkellycollins.triggerfinger.managers.entity.impl;

import com.dkellycollins.triggerfinger.data.daos.IPlayerDao;
import com.dkellycollins.triggerfinger.data.entity.IPlayer;
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IPlayerEntityManager;
import com.dkellycollins.triggerfinger.data.model.IVector;

public class PlayerEntityManager implements IPlayerEntityManager {

    private final IPlayerDao _dao;
    private final ICollidableEntityManager _collidableManager;

    public PlayerEntityManager(IPlayerDao dao, ICollidableEntityManager collidableManager) {
        _dao = dao;
        _collidableManager = collidableManager;
    }

    @Override
    public Iterable<IPlayer> retrieve() {
        return _dao.retrieve();
    }

    @Override
    public IPlayer get(int playerId) {
        return _dao.retrieve(playerId);
    }

    @Override
    public int create(IVector position) {
        int collidableId = _collidableManager.create(position, 50);
        return _dao.create(collidableId);
    }

    @Override
    public void delete(int playerId) {
        _dao.delete(playerId);
    }
}
