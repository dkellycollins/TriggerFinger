package com.dkellycollins.triggerfinger.data.daos.impl;

import com.dkellycollins.triggerfinger.data.daos.ITimerDao;
import com.dkellycollins.triggerfinger.data.entity.ITimer;
import com.dkellycollins.triggerfinger.data.entity.impl.Timer;

import java.util.HashMap;

public class TimerDao extends BaseEntityDao<Timer> implements ITimerDao {

    public TimerDao() {
        super("TimerDao");
    }

    @Override
    public Iterable<ITimer> retrieve() {
        return (Iterable<ITimer>) (Iterable<?>) _store.values();
    }

    @Override
    public ITimer retrieve(int id) {
        return _store.get(id);
    }

    @Override
    public int create(int setTime, int currentTime, boolean isRunning) {
        int id = getNextId();
        Timer timer = new Timer(id, setTime, currentTime, isRunning);

        _store.put(id, timer);

        return id;
    }

    @Override
    public void update(int id, int currentTime, boolean isRunning) {
        Timer timer = _store.get(id);

        timer.setCurrentTime(currentTime);
        timer.setRunning(isRunning);
    }

    @Override
    public void delete(int id) {
        _store.remove(id);
    }
}
