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

public class PlayerViewManager extends BaseSpriteViewManager implements IViewManager {

    private final IPlayerEntityManager _playerManager;
    private final IPlayerConfig _playerConfig;
    private final ICollidableEntityManager _collidableManager;

    public PlayerViewManager(IPlayerEntityManager playerManager, IPlayerConfig playerConfig, ICollidableEntityManager collidableManager, IBitmapEntityManager bitmapManager) {
        super(bitmapManager);

        _playerManager = playerManager;
        _playerConfig = playerConfig;
        _collidableManager = collidableManager;
    }

    @Override
    public ViewLayer getLayer() {
        return ViewLayer.BASE;
    }

    @Override
    public void render(Canvas canvas) {
        for(IPlayer player : _playerManager.retrieve()) {
            ICollidable collidable = _collidableManager.retrieve(player.getCollidableId());

            drawSprite(canvas, collidable);
        }
    }

    @Override
    protected int getSpriteId() {
        return _playerConfig.getBitmapId();
    }
}
