package com.dkellycollins.triggerfinger.managers.view.impl;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.dkellycollins.triggerfinger.data.entity.ICollidable;
import com.dkellycollins.triggerfinger.data.entity.IEnemy;
import com.dkellycollins.triggerfinger.data.entity.IPlayer;
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IEnemyEntityManager;
import com.dkellycollins.triggerfinger.managers.view.IViewManager;

/**
 * Created by Devin on 9/5/2015.
 */
public class EnemyViewManager implements IViewManager {

    private final IEnemyEntityManager _enemyManager;
    private final ICollidableEntityManager _collidableManager;

    public EnemyViewManager(IEnemyEntityManager enemyManager, ICollidableEntityManager collidableManager) {
        _enemyManager = enemyManager;
        _collidableManager = collidableManager;
    }

    @Override
    public int getLayer() {
        return 0;
    }

    @Override
    public void render(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);

        for(IEnemy enemy : _enemyManager.retrieve()) {
            ICollidable collidable = _collidableManager.retrieve(enemy.getCollidableId());

            canvas.drawCircle(collidable.getCenter().getX(), collidable.getCenter().getY(), collidable.getRadius(), paint);
        }
    }

    @Override
    public void dispose() {

    }
}
