package com.dkellycollins.triggerfinger.managers.state.impl;

import com.dkellycollins.triggerfinger.data.entity.ICollidable;
import com.dkellycollins.triggerfinger.data.entity.ITimer;
import com.dkellycollins.triggerfinger.data.entity.IWeapon;
import com.dkellycollins.triggerfinger.managers.entity.IBulletEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.ITimerEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IWeaponEntityManager;
import com.dkellycollins.triggerfinger.managers.state.IStateManager;

public class WeaponStateManager implements IStateManager {

    private final IWeaponEntityManager _weaponManager;
    private final ITimerEntityManager _timerManager;
    private final IBulletEntityManager _bulletManager;
    private final ICollidableEntityManager _collidableManager;

    public WeaponStateManager(IWeaponEntityManager weaponManager, ITimerEntityManager timerManager, IBulletEntityManager bulletManager, ICollidableEntityManager collidableManager) {
        _weaponManager = weaponManager;
        _timerManager = timerManager;
        _bulletManager = bulletManager;
        _collidableManager = collidableManager;
    }

    @Override
    public void init() {

    }

    @Override
    public void update(long deltaTime) {

        for(IWeapon weapon : _weaponManager.retrieve()) {
            ITimer timer = _timerManager.retrieve(weapon.getTimerId());

            if(timer.getCurrentTime() == 0) {
                ICollidable collidable = _collidableManager.retrieve(weapon.getCollidableId());
                _bulletManager.create(collidable.getCenter());

                _timerManager.reset(weapon.getTimerId());
            }

        }
    }
}
