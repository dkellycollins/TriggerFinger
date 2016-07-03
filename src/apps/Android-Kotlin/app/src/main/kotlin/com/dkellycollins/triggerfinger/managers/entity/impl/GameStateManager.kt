package com.dkellycollins.triggerfinger.managers.entity.impl

import com.dkellycollins.triggerfinger.data.daos.IGameStateDao
import com.dkellycollins.triggerfinger.data.entity.IGameState
import com.dkellycollins.triggerfinger.managers.entity.IGameStateManager

class GameStateManager(private val _dao: IGameStateDao) : IGameStateManager {

    override fun retrieve(): IGameState {
        return _dao.retrieve()
    }

    override fun TogglePause() {
        val gameState = retrieve()

        _dao.update(gameState.IsGameOver(), !gameState.IsPaused())
    }

    override fun TogglePause(isPaused: Boolean) {
        val gameState = retrieve()

        _dao.update(gameState.IsGameOver(), isPaused)
    }

    override fun SetGameOver() {
        val gameState = retrieve()

        _dao.update(true, gameState.IsPaused())
    }

    override fun Reset() {
        _dao.update(false, false)
    }
}
