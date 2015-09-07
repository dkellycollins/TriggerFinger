package com.dkellycollins.triggerfinger.managers.view.impl.debug;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.dkellycollins.triggerfinger.data.entity.ICollidable;
import com.dkellycollins.triggerfinger.data.model.ViewLayer;
import com.dkellycollins.triggerfinger.managers.view.IViewManager;

public abstract class BaseHitboxViewManager implements IViewManager {

    private Paint _paint;

    @Override
    public ViewLayer getLayer() {
        return ViewLayer.HITBOX;
    }

    public void init() {
        _paint = new Paint();

        _paint.setColor(getColor());
        _paint.setStyle(Paint.Style.FILL);
        _paint.setAlpha(50);
    }

    @Override
    public void render(Canvas canvas) {
        for(ICollidable collidable : getCollidables()) {
            canvas.drawCircle(collidable.getCenter().getX(), collidable.getCenter().getY(), collidable.getRadius(), _paint);
        }
    }

    @Override
    public void dispose() {

    }

    protected abstract int getColor();
    protected abstract Iterable<ICollidable> getCollidables();
}
