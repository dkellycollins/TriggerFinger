package com.dkellycollins.triggerfinger;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.dkellycollins.triggerfinger.managers.state.IStateManager;
import com.dkellycollins.triggerfinger.managers.view.IViewManager;
import com.dkellycollins.triggerfinger.util.logger.ILogger;

import java.util.List;

public class GameThread extends Thread {

    private final SurfaceView _view;
    private final Iterable<IStateManager> _stateManagers;
    private final Iterable<IViewManager> _viewManagers;
    private final ILogger _logger;

    private boolean _active;
    private long _timestamp;

    public GameThread(SurfaceView view, Iterable<IStateManager> stateManagers, Iterable<IViewManager> viewManagers, ILogger logger) {
        _view = view;
        _stateManagers = stateManagers;
        _viewManagers = viewManagers;
        _logger = logger;

        _active = false;
        _timestamp = 0;

        _logger.debug("Game thread created.");
    }

    public void setActive(boolean active) {
        _active = active;

        if(_active) {
            _timestamp = System.currentTimeMillis();

            _logger.debug("Game thred activated: " + _timestamp);
        }
    }

    @Override
    public void run() {

        _logger.debug("Init: " + _timestamp);
        init();

        while(_active) {
            update();
            render();
        }

        _logger.debug("Dispose: " + _timestamp);
        dispose();
    }

    private void init() {
        for(IStateManager stateManager : _stateManagers) {
            stateManager.init();
        }
    }

    private void update() {
        long timestamp = System.currentTimeMillis();
        long deltaTime = timestamp - _timestamp;

        for(IStateManager stateManager : _stateManagers) {
            stateManager.update(deltaTime);
        }

        _timestamp = timestamp;
    }

    private void render() {
        Canvas canvas = null;
        SurfaceHolder holder = _view.getHolder();
        try {
            canvas = holder.lockCanvas();

            synchronized (holder) {
                canvas.drawColor(Color.BLUE);
                for(IViewManager viewManager : _viewManagers) {
                    viewManager.Render(canvas);
                }
            }
        } finally {
            if(canvas != null) {
                holder.unlockCanvasAndPost(canvas);
            }
        }
    }

    private void dispose() {
        for(IViewManager viewManager : _viewManagers) {
            viewManager.dispose();
        }
    }
}
