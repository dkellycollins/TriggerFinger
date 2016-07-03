package com.dkellycollins.triggerfinger.data.entity

/**
 * Created by Devin on 9/5/2015.
 */
interface ITimer : IEntity {

    val isRunning: Boolean

    val setTime: Int

    val currentTime: Int

}
