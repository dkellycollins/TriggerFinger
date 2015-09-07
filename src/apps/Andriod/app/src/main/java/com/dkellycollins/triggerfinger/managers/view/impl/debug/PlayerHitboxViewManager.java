package com.dkellycollins.triggerfinger.managers.view.impl.debug;

import android.graphics.Color;

import com.dkellycollins.triggerfinger.data.entity.ICollidable;
import com.dkellycollins.triggerfinger.data.entity.IPlayer;
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IPlayerEntityManager;

import java.util.ArrayList;
import java.util.List;

public class PlayerHitboxViewManager extends BaseHitboxViewManager {

    private final IPlayerEntityManager _playerManager;
    private final ICollidableEntityManager _collidableManager;

    public PlayerHitboxViewManager(IPlayerEntityManager playerManager, ICollidableEntityManager collidableManager) {
        _playerManager = playerManager;
        _collidableManager = collidableManager;
    }

    @Override
    protected int getColor() {
        return Color.GREEN;
    }

    @Override
    protected Iterable<ICollidable> getCollidables() {
        List<ICollidable> collidables = new ArrayList<>();

        for(IPlayer player : _playerManager.retrieve()) {
            collidables.add(_collidableManager.retrieve(player.getCollidableId()));
        }

        return collidables;
    }
}
