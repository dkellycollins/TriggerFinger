package com.dkellycollins.triggerfinger.data.daos

import com.dkellycollins.triggerfinger.data.entity.ITimer

/**
 * Provides te ability to manage timer data.
 */
interface ITimerDao : IActivityDao {

    fun retrieve(): Iterable<ITimer>
    fun retrieve(id: Int): ITimer

    fun create(setTime: Int, currentTime: Int, isRunning: Boolean): Int

    fun update(id: Int, currentTime: Int, isRunning: Boolean)

    fun delete(id: Int)
}
