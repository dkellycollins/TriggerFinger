package com.dkellycollins.triggerfinger.managers.view.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.dkellycollins.triggerfinger.data.config.IEnemyConfig;
import com.dkellycollins.triggerfinger.data.entity.ICollidable;
import com.dkellycollins.triggerfinger.data.entity.IEnemy;
import com.dkellycollins.triggerfinger.data.model.ViewLayer;
import com.dkellycollins.triggerfinger.managers.entity.IBitmapEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IEnemyEntityManager;
import com.dkellycollins.triggerfinger.managers.view.IViewManager;

public class EnemyViewManager extends BaseSpriteViewManager implements IViewManager {

    private final IEnemyConfig _enemyConfig;
    private final IEnemyEntityManager _enemyManager;
    private final ICollidableEntityManager _collidableManager;

    public EnemyViewManager(IEnemyConfig enemyConfig, IBitmapEntityManager bitmapManager, IEnemyEntityManager enemyManager, ICollidableEntityManager collidableManager) {
        super(bitmapManager);

        _enemyConfig = enemyConfig;
        _enemyManager = enemyManager;
        _collidableManager = collidableManager;
    }

    @Override
    public ViewLayer getLayer() {
        return ViewLayer.BASE;
    }

    @Override
    public void render(Canvas canvas) {
        for(IEnemy enemy : _enemyManager.retrieve()) {
            ICollidable collidable = _collidableManager.retrieve(enemy.getCollidableId());

            drawSprite(canvas, collidable);
        }

    }

    @Override
    protected int getSpriteId() {
        return _enemyConfig.getSpriteId();
    }
}
