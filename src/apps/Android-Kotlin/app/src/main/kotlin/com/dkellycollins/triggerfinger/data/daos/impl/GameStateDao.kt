package com.dkellycollins.triggerfinger.data.daos.impl

import android.os.Bundle

import com.dkellycollins.triggerfinger.data.daos.IGameStateDao
import com.dkellycollins.triggerfinger.data.entity.IGameState
import com.dkellycollins.triggerfinger.data.entity.impl.GameState

import java.io.Serializable

class GameStateDao : IGameStateDao {
    private val _gameState: GameState

    init {
        _gameState = GameState(false, false)
    }

    override fun retrieve(): IGameState {
        return _gameState
    }

    override fun update(gameOver: Boolean, isPause: Boolean) {
        _gameState.IsGameOver(gameOver)
        _gameState.IsPaused(isPause)
    }

    override fun saveState(bundle: Bundle) {
        bundle.putSerializable(BUNDLE_ID, _gameState)
    }

    override fun restoreState(bundle: Bundle) {
        _gameState.IsGameOver(false)
        _gameState.IsPaused(false)

        if (bundle == null) {
            return
        }

        val saveState = bundle.getSerializable(BUNDLE_ID)
        if (saveState != null && saveState is GameState) {
            _gameState.IsGameOver(saveState.IsGameOver())
            _gameState.IsPaused(saveState.IsPaused())
        }
    }

    companion object {

        private val BUNDLE_ID = "GameStateDao"
    }
}
