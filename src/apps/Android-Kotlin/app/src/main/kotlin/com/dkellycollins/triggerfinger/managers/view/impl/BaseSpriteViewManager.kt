package com.dkellycollins.triggerfinger.managers.view.impl

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.RectF

import com.dkellycollins.triggerfinger.data.entity.ICollidable
import com.dkellycollins.triggerfinger.managers.entity.IBitmapEntityManager
import com.dkellycollins.triggerfinger.managers.view.IViewManager

abstract class BaseSpriteViewManager protected constructor(private val _bitmapManager: IBitmapEntityManager) : IViewManager {

    override fun init() {
        _bitmapManager.load(spriteId)
    }

    override fun dispose() {
        _bitmapManager.delete(spriteId)
    }

    protected fun drawSprite(canvas: Canvas, collidable: ICollidable) {
        val sprite = _bitmapManager.retrieve(spriteId)

        canvas.drawBitmap(sprite, null, getDestinationRect(collidable), null)
    }


    protected abstract val spriteId: Int

    private fun getDestinationRect(collidable: ICollidable): RectF {
        val top = collidable.center.y - collidable.radius
        val left = collidable.center.x - collidable.radius
        val bottom = collidable.center.y + collidable.radius
        val right = collidable.center.x + collidable.radius

        return RectF(left, top, right, bottom)
    }
}
