package com.dkellycollins.triggerfinger.managers.view.impl

import android.graphics.Bitmap
import android.graphics.Canvas

import com.dkellycollins.triggerfinger.data.config.IEnemyConfig
import com.dkellycollins.triggerfinger.data.entity.ICollidable
import com.dkellycollins.triggerfinger.data.entity.IEnemy
import com.dkellycollins.triggerfinger.data.model.ViewLayer
import com.dkellycollins.triggerfinger.managers.entity.IBitmapEntityManager
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager
import com.dkellycollins.triggerfinger.managers.entity.IEnemyEntityManager
import com.dkellycollins.triggerfinger.managers.view.IViewManager

class EnemyViewManager(private val _enemyConfig: IEnemyConfig, bitmapManager: IBitmapEntityManager, private val _enemyManager: IEnemyEntityManager, private val _collidableManager: ICollidableEntityManager) : BaseSpriteViewManager(bitmapManager), IViewManager {

    override val layer: ViewLayer
        get() = ViewLayer.BASE

    override fun render(canvas: Canvas) {
        for (enemy in _enemyManager.retrieve()) {
            val collidable = _collidableManager.retrieve(enemy.collidableId)

            drawSprite(canvas, collidable)
        }

    }

    protected override val spriteId: Int
        get() = _enemyConfig.spriteId
}
