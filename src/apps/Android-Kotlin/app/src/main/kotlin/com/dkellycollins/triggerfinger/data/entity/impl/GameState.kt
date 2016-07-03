package com.dkellycollins.triggerfinger.data.entity.impl

import com.dkellycollins.triggerfinger.data.entity.IGameState

import java.io.Serializable

data class GameState(private var _gameOver: Boolean, private var _isPaused: Boolean) : IGameState, Serializable {

    override fun IsGameOver(): Boolean {
        return _gameOver
    }

    override fun IsPaused(): Boolean {
        return _isPaused
    }

    fun IsGameOver(gameOver: Boolean) {
        _gameOver = gameOver
    }

    fun IsPaused(isPaused: Boolean) {
        _isPaused = isPaused
    }
}
