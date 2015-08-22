package com.dkellycollins.triggerfinger.managers.state.impl;

import com.dkellycollins.triggerfinger.daos.ITouchPositionDao;
import com.dkellycollins.triggerfinger.entity.ICollidable;
import com.dkellycollins.triggerfinger.entity.IPlayer;
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IPlayerEntityManager;
import com.dkellycollins.triggerfinger.managers.state.IStateManager;
import com.dkellycollins.triggerfinger.model.IPosition;
import com.dkellycollins.triggerfinger.model.impl.Position;

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
        _playerId = _playerManager.create(new Position(0, 0));
    }

    @Override
    public void update(long deltaTime) {
        IPlayer player = _playerManager.get(_playerId);
        ICollidable collidable = _collidableManager.get(player.getCollidableId());
        IPosition newPosition = _touchPositionDao.getLastPosition();

        _collidableManager.update(player.getCollidableId(), newPosition, collidable.getRadius());
    }
}
