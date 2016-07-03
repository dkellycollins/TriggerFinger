package com.dkellycollins.triggerfinger.managers.view

import android.graphics.Canvas

import com.dkellycollins.triggerfinger.data.model.ViewLayer

/**
 * Represents a manager that handles rendering.
 */
interface IViewManager {

    /**
     * Get the layer this manager should be rendered on. Lower layers should be rendered first.
     * @return
     */
    val layer: ViewLayer

    /**
     * Called during the initialization phase. Any resources the manager will need
     * should be initialized here.
     */
    fun init()

    /**
     * Called during the render phase.
     * @param canvas The canvas to render to.
     */
    fun render(canvas: Canvas)

    fun dispose()
}
