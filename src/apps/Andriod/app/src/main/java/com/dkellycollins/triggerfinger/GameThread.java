package com.dkellycollins.triggerfinger;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.dkellycollins.triggerfinger.managers.state.IStateManager;
import com.dkellycollins.triggerfinger.managers.view.IViewManager;
import com.dkellycollins.triggerfinger.util.logger.ILogger;

public class GameThread extends Thread {

    private final SurfaceView _view;
    private final Iterable<IStateManager> _stateManagers;
    private final Iterable<IViewManager> _viewManagers;
    private final ILogger _logger;
    private final SurfaceHolder _holder;

    private boolean _active;
    private long _timestamp;

    public GameThread(SurfaceView view, Iterable<IStateManager> stateManagers, Iterable<IViewManager> viewManagers, ILogger logger) {
        _view = view;
        _stateManagers = stateManagers;
        _viewManagers = viewManagers;
        _logger = logger;

        _active = false;
        _timestamp = 0;

        _holder = _view.getHolder();

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

        for(IViewManager viewManager : _viewManagers) {
            viewManager.init();
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
        try {
            canvas = _holder.lockCanvas();
            synchronized (_holder) {
                canvas.drawColor(Color.CYAN);
                for(IViewManager viewManager : _viewManagers) {
                    viewManager.render(canvas);
                }
            }
        }
        finally {
            if(canvas != null) {
                _holder.unlockCanvasAndPost(canvas);
            }
        }
    }

    private void dispose() {
        for(IViewManager viewManager : _viewManagers) {
            viewManager.dispose();
        }
    }
}
