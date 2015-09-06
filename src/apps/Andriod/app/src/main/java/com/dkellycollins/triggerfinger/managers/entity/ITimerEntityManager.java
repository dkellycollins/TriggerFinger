package com.dkellycollins.triggerfinger.managers.entity;

import com.dkellycollins.triggerfinger.data.entity.ITimer;

/**
 * Created by Devin on 9/5/2015.
 */
public interface ITimerEntityManager {

    Iterable<ITimer> retrieve();
    ITimer retrieve(int id);

    int create(int setTime);

    void update(int id, int currentTime);
    void reset(int id);

    void delete(int id);

}
