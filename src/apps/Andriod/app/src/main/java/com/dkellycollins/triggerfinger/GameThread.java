package com.dkellycollins.triggerfinger;

import android.graphics.Canvas;
import android.view.SurfaceView;

import com.dkellycollins.triggerfinger.managers.state.IStateManager;
import com.dkellycollins.triggerfinger.managers.view.IViewManager;

import java.util.List;

public class GameThread extends Thread {

    private final SurfaceView _view;
    private final Iterable<IStateManager> _stateManagers;
    private final Iterable<IViewManager> _viewManagers;

    private boolean _active;
    private long _timestamp;

    public GameThread(SurfaceView view, Iterable<IStateManager> stateManagers, Iterable<IViewManager> viewManagers) {
        _view = view;
        _stateManagers = stateManagers;
        _viewManagers = viewManagers;

        _active = false;
        _timestamp = 0;
    }

    public void setActive(boolean active) {
        _active = active;

        if(_active) {
            _timestamp = System.currentTimeMillis();
        }
    }

    @Override
    public void run() {
        init();

        while(_active) {
            update();
            render();
        }

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
        try {
            canvas = _view.getHolder().lockCanvas();

            if(canvas != null) {
                synchronized (_view.getHolder()) {
                    for(IViewManager viewManager : _viewManagers) {
                        viewManager.Render(canvas);
                    }
                }
            }
        } finally {
            if(canvas != null) {
                _view.getHolder().unlockCanvasAndPost(canvas);
            }
        }
    }

    private void dispose() {
        for(IViewManager viewManager : _viewManagers) {
            viewManager.dispose();
        }
    }
}
