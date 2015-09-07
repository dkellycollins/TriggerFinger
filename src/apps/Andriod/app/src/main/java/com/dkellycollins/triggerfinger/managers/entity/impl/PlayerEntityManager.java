package com.dkellycollins.triggerfinger.managers.entity.impl;

import com.dkellycollins.triggerfinger.data.config.IPlayerConfig;
import com.dkellycollins.triggerfinger.data.daos.IPlayerDao;
import com.dkellycollins.triggerfinger.data.entity.IPlayer;
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IPlayerEntityManager;
import com.dkellycollins.triggerfinger.data.model.IVector;
import com.dkellycollins.triggerfinger.managers.entity.IWeaponEntityManager;

public class PlayerEntityManager implements IPlayerEntityManager {

    private final IPlayerDao _dao;
    private final IPlayerConfig _config;
    private final ICollidableEntityManager _collidableManager;
    private final IWeaponEntityManager _weaponManager;

    public PlayerEntityManager(IPlayerDao dao, IPlayerConfig config, ICollidableEntityManager collidableManager, IWeaponEntityManager weaponManager) {
        _dao = dao;
        _config = config;
        _collidableManager = collidableManager;
        _weaponManager = weaponManager;
    }

    @Override
    public Iterable<IPlayer> retrieve() {
        return _dao.retrieve();
    }

    @Override
    public IPlayer retrieve(int playerId) {
        return _dao.retrieve(playerId);
    }

    @Override
    public int create(IVector position) {
        int collidableId = _collidableManager.create(position, _config.getCollidableRadius());
        int weaponId = _weaponManager.create(collidableId);

        return _dao.create(collidableId, weaponId);
    }

    @Override
    public void delete(int playerId) {
        IPlayer player = _dao.retrieve(playerId);
        _dao.delete(playerId);
        _collidableManager.delete(player.getCollidableId());
    }
}
