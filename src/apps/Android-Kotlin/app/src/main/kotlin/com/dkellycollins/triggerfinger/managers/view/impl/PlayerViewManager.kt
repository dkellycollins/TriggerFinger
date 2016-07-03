package com.dkellycollins.triggerfinger.managers.view.impl

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.RectF

import com.dkellycollins.triggerfinger.R
import com.dkellycollins.triggerfinger.data.config.IPlayerConfig
import com.dkellycollins.triggerfinger.data.entity.ICollidable
import com.dkellycollins.triggerfinger.data.entity.IPlayer
import com.dkellycollins.triggerfinger.data.model.ViewLayer
import com.dkellycollins.triggerfinger.managers.entity.IBitmapEntityManager
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager
import com.dkellycollins.triggerfinger.managers.entity.IPlayerEntityManager
import com.dkellycollins.triggerfinger.managers.view.IViewManager

class PlayerViewManager(private val _playerManager: IPlayerEntityManager, private val _playerConfig: IPlayerConfig, private val _collidableManager: ICollidableEntityManager, bitmapManager: IBitmapEntityManager) : BaseSpriteViewManager(bitmapManager), IViewManager {

    override val layer: ViewLayer
        get() = ViewLayer.BASE

    override fun render(canvas: Canvas) {
        for (player in _playerManager.retrieve()) {
            val collidable = _collidableManager.retrieve(player.collidableId)

            drawSprite(canvas, collidable)
        }
    }

    protected override val spriteId: Int
        get() = _playerConfig.bitmapId
}
