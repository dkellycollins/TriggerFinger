package com.dkellycollins.triggerfinger.managers.entity

import com.dkellycollins.triggerfinger.data.entity.ITimer

/**
 * Created by Devin on 9/5/2015.
 */
interface ITimerEntityManager {

    fun retrieve(): Iterable<ITimer>
    fun retrieve(id: Int): ITimer

    fun create(setTime: Int, isRunning: Boolean): Int

    fun update(id: Int, currentTime: Int)
    fun update(id: Int, currentTime: Int, isRunning: Boolean)
    fun reset(id: Int)
    fun start(id: Int)
    fun pause(id: Int)

    fun delete(id: Int)

}
