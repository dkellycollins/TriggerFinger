package com.dkellycollins.triggerfinger.managers.entity;

import com.dkellycollins.triggerfinger.entity.IPlayer;
import com.dkellycollins.triggerfinger.model.IPosition;

import java.util.List;

public interface IPlayerEntityManager {

    Iterable<IPlayer> getAll();

    IPlayer get(int playerId);

    int create(IPosition position);

    void delete(int playerId);
}
