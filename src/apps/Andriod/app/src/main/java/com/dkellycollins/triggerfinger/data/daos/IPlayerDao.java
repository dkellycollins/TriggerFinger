package com.dkellycollins.triggerfinger.data.daos;

import com.dkellycollins.triggerfinger.data.entity.IPlayer;

public interface IPlayerDao {

    int create(int collidableId, int invincibleTimerId, int weaponId, int score, byte health);

    Iterable<IPlayer> retrieve();
    IPlayer retrieve(int id);
    IPlayer playerOne();

    void update(int id, int weaponId, int score, byte health);

    void delete(int id);
}