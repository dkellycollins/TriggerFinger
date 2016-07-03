package com.dkellycollins.triggerfinger.managers.view.impl

import android.graphics.Bitmap
import android.graphics.Canvas

import com.dkellycollins.triggerfinger.data.config.IBulletConfig
import com.dkellycollins.triggerfinger.data.entity.IBullet
import com.dkellycollins.triggerfinger.data.entity.ICollidable
import com.dkellycollins.triggerfinger.data.model.ViewLayer
import com.dkellycollins.triggerfinger.managers.entity.IBitmapEntityManager
import com.dkellycollins.triggerfinger.managers.entity.IBulletEntityManager
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager
import com.dkellycollins.triggerfinger.managers.view.IViewManager

/**
 * Created by Devin on 9/7/2015.
 */
class BulletViewManager(private val _bulletConfig: IBulletConfig, private val _bulletManager: IBulletEntityManager, private val _collidableManager: ICollidableEntityManager, private val _bitmapManager: IBitmapEntityManager) : IViewManager {

    override val layer: ViewLayer
        get() = ViewLayer.BASE

    override fun init() {
        _bitmapManager.load(_bulletConfig.bitmapId)
    }

    override fun render(canvas: Canvas) {
        for (bullet in _bulletManager.retrieve()) {
            val collidable = _collidableManager.retrieve(bullet.collidableId)
            val bitmap = _bitmapManager.retrieve(_bulletConfig.bitmapId)

            val top = collidable.center.y - collidable.radius
            val left = collidable.center.x - collidable.radius

            canvas.drawBitmap(bitmap, left, top, null)
        }
    }

    override fun dispose() {
        _bitmapManager.delete(_bulletConfig.bitmapId)
    }
}
