package com.dkellycollins.triggerfinger.managers.view;

import android.graphics.Canvas;

import com.dkellycollins.triggerfinger.data.model.ViewLayer;

/**
 * Represents a manager that handles rendering.
 */
public interface IViewManager {

    /**
     * Get the layer this manager should be rendered on. Lower layers should be rendered first.
     * @return
     */
    ViewLayer getLayer();

    /**
     * Called during the initialization phase. Any resources the manager will need
     * should be initialized here.
     */
    void init();

    /**
     * Called during the render phase.
     * @param canvas The canvas to render to.
     */
    void render(Canvas canvas);

    void dispose();
}
