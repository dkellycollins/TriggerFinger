package com.dkellycollins.triggerfinger.data.daos.impl;

import com.dkellycollins.triggerfinger.data.daos.IGameStateDao;
import com.dkellycollins.triggerfinger.data.entity.IGameState;
import com.dkellycollins.triggerfinger.data.entity.impl.GameState;

public class GameStateDao implements IGameStateDao {

    private GameState _gameState;

    public GameStateDao() {
        _gameState = new GameState(false, false);
    }

    @Override
    public IGameState retrieve() {
        return _gameState;
    }

    @Override
    public void update(boolean gameOver, boolean isPause) {
        _gameState.IsGameOver(gameOver);
        _gameState.IsPaused(isPause);
    }
}
