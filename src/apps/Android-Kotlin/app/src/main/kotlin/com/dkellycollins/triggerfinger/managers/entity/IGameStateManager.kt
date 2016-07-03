package com.dkellycollins.triggerfinger.managers.entity

import com.dkellycollins.triggerfinger.data.entity.IGameState

interface IGameStateManager {

    fun retrieve(): IGameState

    fun TogglePause()

    fun TogglePause(isPaused: Boolean)

    fun SetGameOver()

    fun Reset()

}
