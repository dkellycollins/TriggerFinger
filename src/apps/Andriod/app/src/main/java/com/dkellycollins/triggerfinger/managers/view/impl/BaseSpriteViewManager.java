package com.dkellycollins.triggerfinger.managers.view.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;

import com.dkellycollins.triggerfinger.data.entity.ICollidable;
import com.dkellycollins.triggerfinger.managers.entity.IBitmapEntityManager;
import com.dkellycollins.triggerfinger.managers.view.IViewManager;

public abstract class BaseSpriteViewManager implements IViewManager {

    private final IBitmapEntityManager _bitmapManager;

    protected BaseSpriteViewManager(IBitmapEntityManager bitmapManager) {
        _bitmapManager = bitmapManager;
    }

    @Override
    public void init() {
        _bitmapManager.load(getSpriteId());
    }

    @Override
    public void dispose() {
        _bitmapManager.delete(getSpriteId());
    }

    protected void drawSprite(Canvas canvas, ICollidable collidable) {
        Bitmap sprite = _bitmapManager.retrieve(getSpriteId());

        canvas.drawBitmap(sprite, null, getDestinationRect(collidable), null);
    }


    protected abstract int getSpriteId();

    private RectF getDestinationRect(ICollidable collidable) {
        float top = collidable.getCenter().getY() - collidable.getRadius();
        float left = collidable.getCenter().getX() - collidable.getRadius();
        float bottom = collidable.getCenter().getY() + collidable.getRadius();
        float right = collidable.getCenter().getX() + collidable.getRadius();

        return new RectF(left, top, right, bottom);
    }
}
