package com.dkellycollins.triggerfinger.data.daos;

import com.dkellycollins.triggerfinger.data.entity.ITimer;

public interface ITimerDao {

    Iterable<ITimer> retrieve();
    ITimer retrieve(int id);

    int create(int setTime, int currentTime);

    void update(int id, int currentTime);

    void delete(int id);
}
