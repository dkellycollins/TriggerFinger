package com.dkellycollins.triggerfinger.data.daos.impl;

import com.dkellycollins.triggerfinger.data.daos.IWeaponDao;
import com.dkellycollins.triggerfinger.data.entity.IWeapon;
import com.dkellycollins.triggerfinger.data.entity.impl.Weapon;

import java.util.HashMap;

/**
 * Created by Devin on 9/6/2015.
 */
public class WeaponDao extends BaseEntityDao implements IWeaponDao {

    private final HashMap<Integer, Weapon> _store;

    public WeaponDao() {
        _store = new HashMap<>();
    }

    @Override
    public Iterable<IWeapon> retrieve() {
        return (Iterable<IWeapon>) (Iterable<?>) _store.values();
    }

    @Override
    public IWeapon retrieve(int id) {
        return _store.get(id);
    }

    @Override
    public int create(int collidableId, int timerId) {
        int id = getNextId();
        Weapon weapon = new Weapon(id, collidableId, timerId);

        _store.put(id, weapon);

        return id;
    }

    @Override
    public void delete(int id) {
        _store.remove(id);
    }
}
