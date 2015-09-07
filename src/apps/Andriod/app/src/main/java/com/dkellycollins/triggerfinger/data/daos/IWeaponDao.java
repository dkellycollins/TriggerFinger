package com.dkellycollins.triggerfinger.data.daos;

import com.dkellycollins.triggerfinger.data.entity.IWeapon;

public interface IWeaponDao {

    Iterable<IWeapon> retrieve();
    IWeapon retrieve(int id);

    int create(int collidableId, int timerId);

    void delete(int id);
}
