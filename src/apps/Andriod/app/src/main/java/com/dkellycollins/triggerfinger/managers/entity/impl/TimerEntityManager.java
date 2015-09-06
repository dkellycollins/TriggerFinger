package com.dkellycollins.triggerfinger.managers.entity.impl;

import com.dkellycollins.triggerfinger.data.daos.ITimerDao;
import com.dkellycollins.triggerfinger.data.entity.ITimer;
import com.dkellycollins.triggerfinger.managers.entity.ITimerEntityManager;

public class TimerEntityManager implements ITimerEntityManager {

    private final ITimerDao _dao;

    public TimerEntityManager(ITimerDao dao) {
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
    public int create(int setTime) {
        return _dao.create(setTime, setTime);
    }

    @Override
    public void update(int id, int currentTime) {
        _dao.update(id, currentTime);
    }

    @Override
    public void reset(int id) {
        ITimer timer = _dao.retrieve(id);
        _dao.update(timer.getId(), timer.getSetTime());
    }

    @Override
    public void delete(int id) {
        _dao.delete(id);
    }
}
