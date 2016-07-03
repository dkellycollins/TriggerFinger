package com.dkellycollins.triggerfinger.data.daos.impl

import android.view.MotionEvent
import android.view.View

import com.dkellycollins.triggerfinger.data.daos.ITouchPositionDao
import com.dkellycollins.triggerfinger.data.model.impl.Vector2
import com.dkellycollins.triggerfinger.data.model.IVector
import com.dkellycollins.triggerfinger.util.logger.ILogger

class TouchPositionDao(private val _view: View) : ITouchPositionDao, View.OnTouchListener {
    private val _position: Vector2

    override var isTouching: Boolean = false
        private set(value: Boolean) {
            super.isTouching = value
        }

    init {

        _position = Vector2()
        isTouching = false

        _view.setOnTouchListener(this)
    }

    override val lastPosition: IVector
        get() = _position

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        _position.x = event.x
        _position.y = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> isTouching = true
            MotionEvent.ACTION_UP -> isTouching = false
        }

        return true
    }
}
