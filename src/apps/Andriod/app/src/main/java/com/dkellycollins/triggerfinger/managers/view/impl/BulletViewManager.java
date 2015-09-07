package com.dkellycollins.triggerfinger.managers.view.impl;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.dkellycollins.triggerfinger.data.entity.IBullet;
import com.dkellycollins.triggerfinger.data.entity.ICollidable;
import com.dkellycollins.triggerfinger.data.entity.IEnemy;
import com.dkellycollins.triggerfinger.managers.entity.IBulletEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager;
import com.dkellycollins.triggerfinger.managers.view.IViewManager;

/**
 * Created by Devin on 9/6/2015.
 */
public class BulletViewManager implements IViewManager {

    private final IBulletEntityManager _bulletManager;
    private final ICollidableEntityManager _collidableEntityManager;

    public BulletViewManager(IBulletEntityManager bulletManager, ICollidableEntityManager collidableEntityManager) {
        _bulletManager = bulletManager;
        _collidableEntityManager = collidableEntityManager;
    }

    @Override
    public int getLayer() {
        return 0;
    }

    @Override
    public void render(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.MAGENTA);
        paint.setStyle(Paint.Style.FILL);

        for(IBullet bullet : _bulletManager.retrieve()) {
            ICollidable collidable = _collidableEntityManager.retrieve(bullet.getCollidableId());

            canvas.drawCircle(collidable.getCenter().getX(), collidable.getCenter().getY(), collidable.getRadius(), paint);
        }
    }

    @Override
    public void dispose() {

    }
}
