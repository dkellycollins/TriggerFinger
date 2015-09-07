package com.dkellycollins.triggerfinger.managers.entity;

import com.dkellycollins.triggerfinger.data.entity.IWeapon;

public interface IWeaponEntityManager {

    Iterable<IWeapon> retrieve();
    IWeapon retrieve(int id);

    int create(int collidableId);

    void delete(int id);

}
