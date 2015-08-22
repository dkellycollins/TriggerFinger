package com.dkellycollins.triggerfinger.managers.entity.impl;

import com.dkellycollins.triggerfinger.daos.IEntityDao;
import com.dkellycollins.triggerfinger.entity.IPlayer;
import com.dkellycollins.triggerfinger.entity.impl.Player;
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IPlayerEntityManager;
import com.dkellycollins.triggerfinger.model.IPosition;

public class PlayerEntityManager extends BaseEntityManager implements IPlayerEntityManager {

    private final IEntityDao<IPlayer> _dao;
    private final ICollidableEntityManager _collidableManager;

    public PlayerEntityManager(IEntityDao<IPlayer> dao, ICollidableEntityManager collidableManager) {
        _dao = dao;
        _collidableManager = collidableManager;
    }

    @Override
    public Iterable<IPlayer> getAll() {
        return _dao.getAll();
    }

    @Override
    public IPlayer get(int playerId) {
        return _dao.get(playerId);
    }

    @Override
    public int create(IPosition position) {
        int collidableId = _collidableManager.create(position, 5);
        Player player = new Player(getNextId(), collidableId);

        return _dao.create(player);
    }

    @Override
    public void delete(int playerId) {
        _dao.delete(playerId);
    }
}
