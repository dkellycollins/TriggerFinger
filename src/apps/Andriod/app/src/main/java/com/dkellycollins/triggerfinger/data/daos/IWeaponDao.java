package com.dkellycollins.triggerfinger.data.daos;

import com.dkellycollins.triggerfinger.data.entity.IWeapon;

/**
 * Provides te ability to manage weapon data.
 */
public interface IWeaponDao extends IActivityDao {

    Iterable<IWeapon> retrieve();
    IWeapon retrieve(int id);

    int create(int collidableId, int timerId);

    void delete(int id);
}
