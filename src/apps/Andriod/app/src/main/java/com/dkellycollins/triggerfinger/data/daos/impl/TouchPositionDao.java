package com.dkellycollins.triggerfinger.data.daos.impl;

import android.view.MotionEvent;
import android.view.View;

import com.dkellycollins.triggerfinger.data.daos.ITouchPositionDao;
import com.dkellycollins.triggerfinger.data.model.impl.Vector2;
import com.dkellycollins.triggerfinger.data.model.IVector;
import com.dkellycollins.triggerfinger.util.logger.ILogger;

public class TouchPositionDao implements ITouchPositionDao, View.OnTouchListener {

    private final View _view;
    private final Vector2 _position;
    private final ILogger _logger;

    public TouchPositionDao(View view, ILogger logger) {
        _view = view;
        _logger = logger;

        _position = new Vector2();
        _view.setOnTouchListener(this);
    }

    @Override
    public IVector getLastPosition() {
        return _position;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        _position.setX(event.getX());
        _position.setY(event.getY());

        _logger.debug("New position: " + _position.toString());

        return true;
    }
}
