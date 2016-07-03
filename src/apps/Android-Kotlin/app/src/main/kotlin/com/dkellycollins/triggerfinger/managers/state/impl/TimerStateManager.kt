package com.dkellycollins.triggerfinger.managers.state.impl

import com.dkellycollins.triggerfinger.data.entity.ITimer
import com.dkellycollins.triggerfinger.managers.entity.ITimerEntityManager
import com.dkellycollins.triggerfinger.managers.state.IStateManager

class TimerStateManager(private val _timerManager: ITimerEntityManager) : IStateManager {

    override fun init() {
        //Do nothing.
    }

    override fun update(deltaTime: Long) {
        for (timer in _timerManager.retrieve()) {
            if (!timer.isRunning) {
                continue
            }

            val currentTime = Math.max(timer.currentTime - deltaTime, 0).toInt()
            _timerManager.update(timer.id, currentTime)
        }
    }
}
