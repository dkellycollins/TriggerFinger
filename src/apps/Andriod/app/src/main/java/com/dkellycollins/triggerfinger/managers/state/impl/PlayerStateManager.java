package com.dkellycollins.triggerfinger.managers.state.impl;

import com.dkellycollins.triggerfinger.data.daos.ITouchPositionDao;
import com.dkellycollins.triggerfinger.data.entity.ICollidable;
import com.dkellycollins.triggerfinger.data.entity.IPlayer;
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IPlayerEntityManager;
import com.dkellycollins.triggerfinger.managers.state.IStateManager;
import com.dkellycollins.triggerfinger.data.model.IVector;
import com.dkellycollins.triggerfinger.data.model.impl.Vector2;

public class PlayerStateManager implements IStateManager {

    private final IPlayerEntityManager _playerManager;
    private final ICollidableEntityManager _collidableManager;
    private final ITouchPositionDao _touchPositionDao;

    private int _playerId;

    public PlayerStateManager(IPlayerEntityManager playerManager, ICollidableEntityManager collidableManager, ITouchPositionDao touchPositionDao) {
        _playerManager = playerManager;
        _collidableManager = collidableManager;
        _touchPositionDao = touchPositionDao;
    }

    @Override
    public void init() {
        _playerId = _playerManager.create(new Vector2());
    }

    @Override
    public void update(long deltaTime) {
        IPlayer player = _playerManager.get(_playerId);
        ICollidable collidable = _collidableManager.retrieve(player.getCollidableId());
        IVector newPosition = _touchPositionDao.getLastPosition();

        _collidableManager.update(player.getCollidableId(), newPosition, collidable.getRadius());
    }
}
