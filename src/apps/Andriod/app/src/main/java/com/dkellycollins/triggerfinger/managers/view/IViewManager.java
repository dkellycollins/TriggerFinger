package com.dkellycollins.triggerfinger.managers.view;

import android.graphics.Canvas;

/**
 * Represents a manager that handles rendering.
 */
public interface IViewManager {

    /**
     * Get the layer this manager should be rendered on. Lower layers should be rendered first.
     * @return
     */
    int getLayer();

    /**
     * Called during the render phase.
     * @param canvas The canvas to render to.
     */
    void Render(Canvas canvas);

    void dispose();
}
