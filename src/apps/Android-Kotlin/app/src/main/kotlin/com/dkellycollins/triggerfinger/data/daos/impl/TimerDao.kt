package com.dkellycollins.triggerfinger.data.daos.impl

import com.dkellycollins.triggerfinger.data.daos.ITimerDao
import com.dkellycollins.triggerfinger.data.entity.ITimer
import com.dkellycollins.triggerfinger.data.entity.impl.Timer

import java.util.HashMap

class TimerDao : BaseEntityDao<Timer>("TimerDao"), ITimerDao {

    override fun retrieve(): Iterable<ITimer> {
        return _store.values
    }

    override fun retrieve(id: Int): ITimer {
        return _store[id]
    }

    override fun create(setTime: Int, currentTime: Int, isRunning: Boolean): Int {
        val id = nextId
        val timer = Timer(id, setTime, currentTime, isRunning)

        _store.put(id, timer)

        return id
    }

    override fun update(id: Int, currentTime: Int, isRunning: Boolean) {
        val timer = _store[id]

        timer.currentTime = currentTime
        timer.isRunning = isRunning
    }

    override fun delete(id: Int) {
        _store.remove(id)
    }
}
