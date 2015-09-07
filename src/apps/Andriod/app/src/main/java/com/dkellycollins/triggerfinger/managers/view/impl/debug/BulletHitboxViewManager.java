package com.dkellycollins.triggerfinger.managers.view.impl.debug;

import android.graphics.Color;

import com.dkellycollins.triggerfinger.data.entity.IBullet;
import com.dkellycollins.triggerfinger.data.entity.ICollidable;
import com.dkellycollins.triggerfinger.managers.entity.IBulletEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Devin on 9/7/2015.
 */
public class BulletHitboxViewManager extends BaseHitboxViewManager {

    private final IBulletEntityManager _bulletManager;
    private final ICollidableEntityManager _collidableManager;

    public BulletHitboxViewManager(IBulletEntityManager bulletManager, ICollidableEntityManager collidableManager) {
        _bulletManager = bulletManager;
        _collidableManager = collidableManager;
    }

    @Override
    protected int getColor() {
        return Color.MAGENTA;
    }

    @Override
    protected Iterable<ICollidable> getCollidables() {
        List<ICollidable> collidables = new ArrayList<>();

        for(IBullet bullet : _bulletManager.retrieve()) {
            collidables.add(_collidableManager.retrieve(bullet.getCollidableId()));
        }

        return collidables;
    }
}
