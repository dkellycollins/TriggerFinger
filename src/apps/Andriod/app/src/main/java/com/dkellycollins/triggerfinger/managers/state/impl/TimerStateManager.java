package com.dkellycollins.triggerfinger.managers.state.impl;

import com.dkellycollins.triggerfinger.data.entity.ITimer;
import com.dkellycollins.triggerfinger.managers.entity.ITimerEntityManager;
import com.dkellycollins.triggerfinger.managers.state.IStateManager;

public class TimerStateManager implements IStateManager {

    private final ITimerEntityManager _timerManager;

    public TimerStateManager(ITimerEntityManager timerManager) {
        _timerManager = timerManager;
    }

    @Override
    public void init() {
        //Do nothing.
    }

    @Override
    public void update(long deltaTime) {
        for(ITimer timer : _timerManager.retrieve()) {
            int currentTime = (int)Math.max(timer.getCurrentTime() - deltaTime, 0);
            _timerManager.update(timer.getId(), currentTime);
        }
    }
}
