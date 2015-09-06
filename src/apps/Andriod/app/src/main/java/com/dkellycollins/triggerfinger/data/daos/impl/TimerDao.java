package com.dkellycollins.triggerfinger.data.daos.impl;

import com.dkellycollins.triggerfinger.data.daos.ITimerDao;
import com.dkellycollins.triggerfinger.data.entity.ITimer;
import com.dkellycollins.triggerfinger.data.entity.impl.Timer;

import java.util.HashMap;

public class TimerDao extends BaseEntityDao implements ITimerDao {

    private final HashMap<Integer, Timer> _store;

    public TimerDao() {
        _store = new HashMap<>();
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
    public int create(int setTime, int currentTime) {
        int id = getNextId();
        Timer timer = new Timer(id, setTime, currentTime);

        _store.put(id, timer);

        return id;
    }

    @Override
    public void update(int id, int currentTime) {
        Timer timer = _store.get(id);

        timer.setCurrentTime(currentTime);
    }

    @Override
    public void delete(int id) {
        _store.remove(id);
    }
}
