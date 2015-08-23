package com.dkellycollins.triggerfinger.data.daos.impl;

import android.view.MotionEvent;
import android.view.View;

import com.dkellycollins.triggerfinger.data.daos.ITouchPositionDao;
import com.dkellycollins.triggerfinger.data.model.impl.Position;
import com.dkellycollins.triggerfinger.data.model.IPosition;

public class TouchPositionDao implements ITouchPositionDao, View.OnTouchListener {

    private final View _view;
    private final Position _position;

    public TouchPositionDao(View view) {
        _view = view;

        _position = new Position(0, 0);
        _view.setOnTouchListener(this);
    }

    @Override
    public IPosition getLastPosition() {
        return _position;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        _position.setX(event.getX());
        _position.setY(event.getY());

        return true;
    }
}
