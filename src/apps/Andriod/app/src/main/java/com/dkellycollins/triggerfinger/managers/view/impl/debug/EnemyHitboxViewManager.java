package com.dkellycollins.triggerfinger.managers.view.impl.debug;

import android.graphics.Color;

import com.dkellycollins.triggerfinger.data.entity.ICollidable;
import com.dkellycollins.triggerfinger.data.entity.IEnemy;
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IEnemyEntityManager;

import java.util.ArrayList;
import java.util.List;

public class EnemyHitboxViewManager extends BaseHitboxViewManager {

    private final IEnemyEntityManager _enemyManager;
    private final ICollidableEntityManager _collidableManager;

    public EnemyHitboxViewManager(IEnemyEntityManager enemyManager, ICollidableEntityManager collidableManager) {
        _enemyManager = enemyManager;
        _collidableManager = collidableManager;
    }

    @Override
    protected int getColor() {
        return Color.RED;
    }

    @Override
    protected Iterable<ICollidable> getCollidables() {
        List<ICollidable> collidables = new ArrayList<>();

        for(IEnemy enemy : _enemyManager.retrieve()) {
            collidables.add(_collidableManager.retrieve(enemy.getCollidableId()));
        }

        return collidables;
    }
}
