package com.dkellycollins.triggerfinger

import android.graphics.Canvas
import android.graphics.Color
import android.view.SurfaceHolder
import android.view.SurfaceView

import com.dkellycollins.triggerfinger.managers.state.IStateManager
import com.dkellycollins.triggerfinger.managers.view.IViewManager
import com.dkellycollins.triggerfinger.util.logger.ILogger

import java.util.Collections
import java.util.Comparator

class GameThread(private val _view: SurfaceView, private val _stateManagers: Iterable<IStateManager>, private val _viewManagers: Iterable<IViewManager>, private val _logger: ILogger) : Thread() {
    private val _holder: SurfaceHolder

    private var _active: Boolean = false
    private var _timestamp: Long = 0

    init {

        _active = false
        _timestamp = 0

        _holder = _view.holder

        _logger.debug("Game thread created.")
    }

    fun setActive(active: Boolean) {
        _active = active

        if (_active) {
            _timestamp = System.currentTimeMillis()

            _logger.debug("Game thred activated: " + _timestamp)
        }
    }

    override fun run() {

        _logger.debug("Init: " + _timestamp)
        init()

        while (_active) {
            update()
            render()
        }

        _logger.debug("Dispose: " + _timestamp)
        dispose()
    }

    private fun init() {
        for (stateManager in _stateManagers) {
            stateManager.init()
        }

        for (viewManager in _viewManagers) {
            viewManager.init()
        }
    }

    private fun update() {
        val timestamp = System.currentTimeMillis()
        val deltaTime = timestamp - _timestamp

        for (stateManager in _stateManagers) {
            stateManager.update(deltaTime)
        }

        _timestamp = timestamp
    }

    private fun render() {
        var canvas: Canvas? = null
        try {
            canvas = _holder.lockCanvas()
            if (canvas != null) {
                synchronized (_holder) {
                    canvas!!.drawColor(Color.CYAN)
                    for (viewManager in _viewManagers) {
                        viewManager.render(canvas)
                    }
                }
            }
        } finally {
            if (canvas != null) {
                _holder.unlockCanvasAndPost(canvas)
            }
        }
    }

    private fun dispose() {
        for (viewManager in _viewManagers) {
            viewManager.dispose()
        }
    }
}
