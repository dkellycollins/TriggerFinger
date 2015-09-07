package com.dkellycollins.triggerfinger.managers.state.impl;

import com.dkellycollins.triggerfinger.data.daos.ITouchPositionDao;
import com.dkellycollins.triggerfinger.data.entity.ICollidable;
import com.dkellycollins.triggerfinger.data.entity.IPlayer;
import com.dkellycollins.triggerfinger.data.entity.ITimer;
import com.dkellycollins.triggerfinger.data.entity.IWeapon;
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IPlayerEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.ITimerEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IWeaponEntityManager;
import com.dkellycollins.triggerfinger.managers.state.IStateManager;
import com.dkellycollins.triggerfinger.data.model.IVector;
import com.dkellycollins.triggerfinger.data.model.impl.Vector2;

public class PlayerStateManager implements IStateManager {

    private final IPlayerEntityManager _playerManager;
    private final ICollidableEntityManager _collidableManager;
    private final ITouchPositionDao _touchPositionDao;
    private final IWeaponEntityManager _weaponManager;
    private final ITimerEntityManager _timerEnityManager;

    private int _playerId;

    public PlayerStateManager(IPlayerEntityManager playerManager, ICollidableEntityManager collidableManager, ITouchPositionDao touchPositionDao, IWeaponEntityManager weaponManager, ITimerEntityManager timerEnityManager) {
        _playerManager = playerManager;
        _collidableManager = collidableManager;
        _touchPositionDao = touchPositionDao;
        _weaponManager = weaponManager;
        _timerEnityManager = timerEnityManager;
    }

    @Override
    public void init() {
        _playerId = _playerManager.create(new Vector2());
    }

    @Override
    public void update(long deltaTime) {
        IPlayer player = _playerManager.retrieve(_playerId);
        ICollidable collidable = _collidableManager.retrieve(player.getCollidableId());
        IVector newPosition = _touchPositionDao.getLastPosition();

        _collidableManager.update(player.getCollidableId(), newPosition, collidable.getRadius());

        IWeapon weapon = _weaponManager.retrieve(player.getWeaponId());
        ITimer timer = _timerEnityManager.retrieve(weapon.getTimerId());

        boolean isTouching = _touchPositionDao.isTouching();
        _timerEnityManager.update(timer.getId(), (isTouching) ? timer.getCurrentTime() : 1, isTouching);
    }
}
