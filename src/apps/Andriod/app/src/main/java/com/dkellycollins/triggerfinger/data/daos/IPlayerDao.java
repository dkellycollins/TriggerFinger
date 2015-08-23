package com.dkellycollins.triggerfinger.data.daos;

import com.dkellycollins.triggerfinger.data.entity.IPlayer;

public interface IPlayerDao {

    int create(int collidableId);

    Iterable<IPlayer> retrieve();
    IPlayer retrieve(int id);

    void update(int id, int collidableId);

    void delete(int id);
}