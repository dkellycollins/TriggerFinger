package com.dkellycollins.triggerfinger.data.daos;

import com.dkellycollins.triggerfinger.data.entity.ITimer;

/**
 * Provides te ability to manage timer data.
 */
public interface ITimerDao extends IActivityDao {

    Iterable<ITimer> retrieve();
    ITimer retrieve(int id);

    int create(int setTime, int currentTime, boolean isRunning);

    void update(int id, int currentTime, boolean isRunning);

    void delete(int id);
}
