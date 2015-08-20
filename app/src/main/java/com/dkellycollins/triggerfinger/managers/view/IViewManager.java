package com.dkellycollins.triggerfinger.managers.view;

import android.graphics.Canvas;

/**
 * Represents a manager that handles rendering.
 */
public interface IViewManager {

    /**
     * Called during the render phase.
     * @param canvas The canvas to render to.
     */
    void Render(Canvas canvas);
}
