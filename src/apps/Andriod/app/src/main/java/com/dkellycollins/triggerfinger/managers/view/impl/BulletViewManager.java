package com.dkellycollins.triggerfinger.managers.view.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.dkellycollins.triggerfinger.data.config.IBulletConfig;
import com.dkellycollins.triggerfinger.data.entity.IBullet;
import com.dkellycollins.triggerfinger.data.entity.ICollidable;
import com.dkellycollins.triggerfinger.data.model.ViewLayer;
import com.dkellycollins.triggerfinger.managers.entity.IBitmapEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IBulletEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager;
import com.dkellycollins.triggerfinger.managers.view.IViewManager;

/**
 * Created by Devin on 9/7/2015.
 */
public class BulletViewManager implements IViewManager {

    private final IBulletConfig _bulletConfig;
    private final IBulletEntityManager _bulletManager;
    private final ICollidableEntityManager _collidableManager;
    private final IBitmapEntityManager _bitmapManager;

    public BulletViewManager(IBulletConfig bulletConfig, IBulletEntityManager bulletManager, ICollidableEntityManager collidableManager, IBitmapEntityManager bitmapManager) {
        _bulletConfig = bulletConfig;
        _bulletManager = bulletManager;
        _collidableManager = collidableManager;
        _bitmapManager = bitmapManager;
    }

    @Override
    public ViewLayer getLayer() {
        return ViewLayer.BASE;
    }

    @Override
    public void init() {
        _bitmapManager.load(_bulletConfig.getBitmapId());
    }

    @Override
    public void render(Canvas canvas) {
        for(IBullet bullet : _bulletManager.retrieve()) {
            ICollidable collidable = _collidableManager.retrieve(bullet.getCollidableId());
            Bitmap bitmap = _bitmapManager.retrieve(_bulletConfig.getBitmapId());

            float top = collidable.getCenter().getY() - collidable.getRadius();
            float left = collidable.getCenter().getX() - collidable.getRadius();

            canvas.drawBitmap(bitmap, left, top, null);
        }
    }

    @Override
    public void dispose() {
        _bitmapManager.delete(_bulletConfig.getBitmapId());
    }
}
