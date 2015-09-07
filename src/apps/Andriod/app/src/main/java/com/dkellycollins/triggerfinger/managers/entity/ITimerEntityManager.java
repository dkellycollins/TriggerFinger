package com.dkellycollins.triggerfinger.managers.entity;

import com.dkellycollins.triggerfinger.data.entity.ITimer;

/**
 * Created by Devin on 9/5/2015.
 */
public interface ITimerEntityManager {

    Iterable<ITimer> retrieve();
    ITimer retrieve(int id);

    int create(int setTime, boolean isRunning);

    void update(int id, int currentTime);
    void update(int id, int currentTime, boolean isRunning);
    void reset(int id);
    void start(int id);
    void pause(int id);

    void delete(int id);

}
