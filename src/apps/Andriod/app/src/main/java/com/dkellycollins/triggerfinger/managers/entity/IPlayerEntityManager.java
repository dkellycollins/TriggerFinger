package com.dkellycollins.triggerfinger.managers.entity;

import com.dkellycollins.triggerfinger.data.entity.IPlayer;
import com.dkellycollins.triggerfinger.data.model.IPosition;

public interface IPlayerEntityManager {

    Iterable<IPlayer> retrieve();

    IPlayer get(int playerId);

    int create(IPosition position);

    void delete(int playerId);
}
