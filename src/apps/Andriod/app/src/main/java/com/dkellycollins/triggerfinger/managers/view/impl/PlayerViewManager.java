package com.dkellycollins.triggerfinger.managers.view.impl;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.dkellycollins.triggerfinger.data.entity.ICollidable;
import com.dkellycollins.triggerfinger.data.entity.IPlayer;
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IPlayerEntityManager;
import com.dkellycollins.triggerfinger.managers.view.IViewManager;

public class PlayerViewManager implements IViewManager {

    private final IPlayerEntityManager _playerManager;
    private final ICollidableEntityManager _collidableManager;

    public PlayerViewManager(IPlayerEntityManager playerManager, ICollidableEntityManager collidableManager) {
        _playerManager = playerManager;
        _collidableManager = collidableManager;
    }

    @Override
    public int getLayer() {
        return 0;
    }

    @Override
    public void render(Canvas canvas) {

        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);

        for(IPlayer player : _playerManager.retrieve()) {
            ICollidable collidable = _collidableManager.retrieve(player.getCollidableId());

            canvas.drawCircle(collidable.getCenter().getX(), collidable.getCenter().getY(), collidable.getRadius(), paint);
        }
    }

    @Override
    public void dispose() {

    }
}
