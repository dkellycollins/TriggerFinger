package com.dkellycollins.triggerfinger.managers.state.impl;

import com.dkellycollins.triggerfinger.data.entity.ITimer;
import com.dkellycollins.triggerfinger.managers.entity.ITimerEntityManager;
import com.dkellycollins.triggerfinger.managers.state.IStateManager;
import com.dkellycollins.triggerfinger.util.qa.Assert;

public class TimerStateManager implements IStateManager {

    private final ITimerEntityManager _timerManager;

    public TimerStateManager(ITimerEntityManager timerManager) {
        Assert.isNotNull(timerManager, "timerManager");

        _timerManager = timerManager;
    }

    @Override
    public void init() {
        //Do nothing.
    }

    @Override
    public void update(long deltaTime) {
        for(ITimer timer : _timerManager.retrieve()) {
            if(!timer.isRunning()) {
                continue;
            }

            int currentTime = (int)Math.max(timer.getCurrentTime() - deltaTime, 0);
            _timerManager.update(timer.getId(), currentTime);
        }
    }
}
