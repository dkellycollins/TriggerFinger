package com.dkellycollins.triggerfinger.data.entity;

/**
 * Created by Devin on 9/5/2015.
 */
public interface ITimer extends IEntity {

    boolean isRunning();

    int getSetTime();

    int getCurrentTime();

}
