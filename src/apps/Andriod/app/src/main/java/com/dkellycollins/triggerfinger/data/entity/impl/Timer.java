package com.dkellycollins.triggerfinger.data.entity.impl;

import com.dkellycollins.triggerfinger.data.entity.ITimer;

public class Timer implements ITimer {

    private final int _id;
    private final int _setTime;

    private int _currentTime;
    private boolean _isRunning;

    public Timer(int id, int setTime, int currentTime, boolean isRunning) {
        _id = id;
        _setTime = setTime;
        _currentTime = currentTime;
        _isRunning = isRunning;
    }

    @Override
    public boolean isRunning() {
        return _isRunning;
    }

    @Override
    public int getSetTime() {
        return _setTime;
    }

    @Override
    public int getCurrentTime() {
        return _currentTime;
    }

    @Override
    public int getId() {
        return _id;
    }

    public void setCurrentTime(int currentTime) {
        _currentTime = currentTime;
    }

    public void setRunning(boolean isRunning) {
        _isRunning = isRunning;
    }
}
