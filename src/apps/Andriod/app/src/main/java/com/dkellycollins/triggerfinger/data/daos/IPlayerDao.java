package com.dkellycollins.triggerfinger.data.daos;

import com.dkellycollins.triggerfinger.data.entity.IPlayer;

public interface IPlayerDao {

    int create(int collidableId, int weaponId);

    Iterable<IPlayer> retrieve();
    IPlayer retrieve(int id);

    void update(int id, int weaponId);

    void delete(int id);
}