package com.dkellycollins.triggerfinger.managers.view.impl.debug

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

import com.dkellycollins.triggerfinger.data.entity.ICollidable
import com.dkellycollins.triggerfinger.data.model.ViewLayer
import com.dkellycollins.triggerfinger.managers.view.IViewManager

abstract class BaseHitboxViewManager : IViewManager {

    private var _paint: Paint? = null

    override val layer: ViewLayer
        get() = ViewLayer.HITBOX

    override fun init() {
        _paint = Paint()

        _paint!!.color = color
        _paint!!.style = Paint.Style.FILL
        _paint!!.alpha = 50
    }

    override fun render(canvas: Canvas) {
        for (collidable in collidables) {
            canvas.drawCircle(collidable.center.x, collidable.center.y, collidable.radius, _paint!!)
        }
    }

    override fun dispose() {

    }

    protected abstract val color: Int
    protected abstract val collidables: Iterable<ICollidable>
}
