package com.dkellycollins.triggerfinger.managers.entity.impl

import com.dkellycollins.triggerfinger.data.daos.ITimerDao
import com.dkellycollins.triggerfinger.data.entity.ITimer
import com.dkellycollins.triggerfinger.managers.entity.ITimerEntityManager

class TimerEntityManager(private val _dao: ITimerDao) : ITimerEntityManager {

    override fun retrieve(): Iterable<ITimer> {
        return _dao.retrieve()
    }

    override fun retrieve(id: Int): ITimer {
        return _dao.retrieve(id)
    }

    override fun create(setTime: Int, isRunning: Boolean): Int {
        return _dao.create(setTime, setTime, isRunning)
    }

    override fun update(id: Int, currentTime: Int) {
        val timer = _dao.retrieve(id)
        _dao.update(id, currentTime, timer.isRunning)
    }

    override fun update(id: Int, currentTime: Int, isRunning: Boolean) {
        _dao.update(id, currentTime, isRunning)
    }

    override fun reset(id: Int) {
        val timer = _dao.retrieve(id)
        _dao.update(timer.id, timer.setTime, timer.isRunning)
    }

    override fun start(id: Int) {
        val timer = _dao.retrieve(id)
        _dao.update(timer.id, timer.currentTime, true)
    }

    override fun pause(id: Int) {
        val timer = _dao.retrieve(id)
        _dao.update(timer.id, timer.currentTime, false)
    }

    override fun delete(id: Int) {
        _dao.delete(id)
    }
}
