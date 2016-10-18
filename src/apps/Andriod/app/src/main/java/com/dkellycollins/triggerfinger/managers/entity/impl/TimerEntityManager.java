package com.dkellycollins.triggerfinger.managers.entity.impl;

import com.dkellycollins.triggerfinger.data.daos.ITimerDao;
import com.dkellycollins.triggerfinger.data.entity.ITimer;
import com.dkellycollins.triggerfinger.managers.entity.ITimerEntityManager;
import com.dkellycollins.triggerfinger.util.qa.Assert;

public class TimerEntityManager implements ITimerEntityManager {

    private final ITimerDao _dao;

    public TimerEntityManager(ITimerDao dao) {
        Assert.isNotNull(dao, "dao");

        _dao = dao;
    }

    @Override
    public Iterable<ITimer> retrieve() {
        return _dao.retrieve();
    }

    @Override
    public ITimer retrieve(int id) {
        return _dao.retrieve(id);
    }

    @Override
    public int create(int setTime, boolean isRunning) {
        return _dao.create(setTime, setTime, isRunning);
    }

    @Override
    public void update(int id, int currentTime) {
        ITimer timer = _dao.retrieve(id);
        _dao.update(id, currentTime, timer.isRunning());
    }

    @Override
    public void update(int id, int currentTime, boolean isRunning) {
        _dao.update(id, currentTime, isRunning);
    }

    @Override
    public void reset(int id) {
        ITimer timer = _dao.retrieve(id);
        _dao.update(timer.getId(), timer.getSetTime(), timer.isRunning());
    }

    @Override
    public void start(int id) {
        ITimer timer = _dao.retrieve(id);
        _dao.update(timer.getId(), timer.getCurrentTime(), true);
    }

    @Override
    public void pause(int id) {
        ITimer timer = _dao.retrieve(id);
        _dao.update(timer.getId(), timer.getCurrentTime(), false);
    }

    @Override
    public void delete(int id) {
        _dao.delete(id);
    }
}
