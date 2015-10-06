package com.dkellycollins.triggerfinger.managers.view.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;

import com.dkellycollins.triggerfinger.R;
import com.dkellycollins.triggerfinger.data.config.IPlayerConfig;
import com.dkellycollins.triggerfinger.data.entity.ICollidable;
import com.dkellycollins.triggerfinger.data.entity.IPlayer;
import com.dkellycollins.triggerfinger.data.model.ViewLayer;
import com.dkellycollins.triggerfinger.managers.entity.IBitmapEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IPlayerEntityManager;
import com.dkellycollins.triggerfinger.managers.view.IViewManager;

public class PlayerViewManager implements IViewManager {

    private final IPlayerEntityManager _playerManager;
    private final IPlayerConfig _playerConfig;
    private final ICollidableEntityManager _collidableManager;
    private final IBitmapEntityManager _bitmapManager;

    public PlayerViewManager(IPlayerEntityManager playerManager, IPlayerConfig playerConfig, ICollidableEntityManager collidableManager, IBitmapEntityManager bitmapManager) {
        _playerManager = playerManager;
        _playerConfig = playerConfig;
        _collidableManager = collidableManager;
        _bitmapManager = bitmapManager;
    }

    @Override
    public ViewLayer getLayer() {
        return ViewLayer.BASE;
    }

    @Override
    public void init() {
        _bitmapManager.load(_playerConfig.getBitmapId());
    }

    @Override
    public void render(Canvas canvas) {
        for(IPlayer player : _playerManager.retrieve()) {
            ICollidable collidable = _collidableManager.retrieve(player.getCollidableId());
            Bitmap bitmap = _bitmapManager.retrieve(_playerConfig.getBitmapId());

            canvas.drawBitmap(bitmap, null, getDestinationRect(collidable), null);
        }
    }

    @Override
    public void dispose() {
        _bitmapManager.delete(_playerConfig.getBitmapId());
    }

    private RectF getDestinationRect(ICollidable collidable) {
        float top = collidable.getCenter().getY() - collidable.getRadius();
        float left = collidable.getCenter().getX() - collidable.getRadius();
        float bottom = collidable.getCenter().getY() + collidable.getRadius();
        float right = collidable.getCenter().getX() + collidable.getRadius();

        return new RectF(left, top, right, bottom);
    }
}
