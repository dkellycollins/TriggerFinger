package com.dkellycollins.triggerfinger.data.entity.impl

import com.dkellycollins.triggerfinger.data.entity.ITimer

import java.io.Serializable

data class Timer(override val id: Int, override val setTime: Int, override var currentTime: Int, override var isRunning: Boolean) : ITimer, Serializable
