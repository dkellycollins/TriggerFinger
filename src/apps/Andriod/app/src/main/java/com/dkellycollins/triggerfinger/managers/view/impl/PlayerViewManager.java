package com.dkellycollins.triggerfinger.managers.view.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.dkellycollins.triggerfinger.R;
import com.dkellycollins.triggerfinger.data.entity.ICollidable;
import com.dkellycollins.triggerfinger.data.entity.IPlayer;
import com.dkellycollins.triggerfinger.data.model.ViewLayer;
import com.dkellycollins.triggerfinger.managers.entity.IBitmapEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IPlayerEntityManager;
import com.dkellycollins.triggerfinger.managers.view.IViewManager;

public class PlayerViewManager implements IViewManager {

    private final IPlayerEntityManager _playerManager;
    private final ICollidableEntityManager _collidableManager;
    private final IBitmapEntityManager _bitmapManager;

    public PlayerViewManager(IPlayerEntityManager playerManager, ICollidableEntityManager collidableManager, IBitmapEntityManager bitmapManager) {
        _playerManager = playerManager;
        _collidableManager = collidableManager;
        _bitmapManager = bitmapManager;
    }

    @Override
    public ViewLayer getLayer() {
        return ViewLayer.BASE;
    }

    @Override
    public void init() {
        _bitmapManager.load(R.drawable.shuttle);
    }

    @Override
    public void render(Canvas canvas) {
        for(IPlayer player : _playerManager.retrieve()) {
            ICollidable collidable = _collidableManager.retrieve(player.getCollidableId());
            Bitmap bitmap = _bitmapManager.retrieve(R.drawable.shuttle);

            float left = collidable.getCenter().getX() - collidable.getRadius();
            float top = collidable.getCenter().getY() - collidable.getRadius();

            canvas.drawBitmap(bitmap, left, top, null);
        }
    }

    @Override
    public void dispose() {

    }
}
