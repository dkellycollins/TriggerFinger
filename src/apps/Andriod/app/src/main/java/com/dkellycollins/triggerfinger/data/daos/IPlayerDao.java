package com.dkellycollins.triggerfinger.data.daos;

import com.dkellycollins.triggerfinger.data.entity.IPlayer;

public interface IPlayerDao {

    int create(int collidableId, int weaponId, int score);

    Iterable<IPlayer> retrieve();
    IPlayer retrieve(int id);
    IPlayer playerOne();

    void update(int id, int weaponId, int score);

    void delete(int id);
}