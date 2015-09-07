package com.dkellycollins.triggerfinger.managers.entity.impl;

import com.dkellycollins.triggerfinger.data.daos.IWeaponDao;
import com.dkellycollins.triggerfinger.data.entity.IWeapon;
import com.dkellycollins.triggerfinger.managers.entity.ITimerEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IWeaponEntityManager;

public class WeaponEntityManager implements IWeaponEntityManager {

    private final IWeaponDao _dao;
    private final ITimerEntityManager _timerManager;

    public WeaponEntityManager(IWeaponDao dao, ITimerEntityManager timerManager) {
        _dao = dao;
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
        int timerId = _timerManager.create(5000, true);
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
