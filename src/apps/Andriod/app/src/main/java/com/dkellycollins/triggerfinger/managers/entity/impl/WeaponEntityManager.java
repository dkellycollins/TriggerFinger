package com.dkellycollins.triggerfinger.managers.entity.impl;

import com.dkellycollins.triggerfinger.data.config.IBulletConfig;
import com.dkellycollins.triggerfinger.data.daos.IWeaponDao;
import com.dkellycollins.triggerfinger.data.entity.IWeapon;
import com.dkellycollins.triggerfinger.managers.entity.ITimerEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IWeaponEntityManager;

public class WeaponEntityManager implements IWeaponEntityManager {

    private final IWeaponDao _dao;
    private final IBulletConfig _bulletConfig;
    private final ITimerEntityManager _timerManager;

    public WeaponEntityManager(IWeaponDao dao, IBulletConfig bulletConfig, ITimerEntityManager timerManager) {
        _dao = dao;
        _bulletConfig = bulletConfig;
        _timerManager = timerManager;
    }

    @Override
    public Iterable<IWeapon> retrieve() {
        return _dao.retrieve();
    }

    @Override
    public IWeapon retrieve(int id) {
        return _dao.retrieve(id);
    }

    @Override
    public int create(int collidableId) {
        int timerId = _timerManager.create(_bulletConfig.getRespawnRate(), true);
        int weaponId = _dao.create(collidableId, timerId);

        return weaponId;
    }

    @Override
    public void delete(int id) {
        IWeapon weapon = _dao.retrieve(id);

        _timerManager.delete(weapon.getTimerId());
        _dao.delete(weapon.getId());
    }
}
