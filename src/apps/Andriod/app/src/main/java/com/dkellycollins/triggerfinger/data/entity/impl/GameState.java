package com.dkellycollins.triggerfinger.data.entity.impl;

import com.dkellycollins.triggerfinger.data.entity.IGameState;

public class GameState implements IGameState {

    private boolean _gameOver;
    private boolean _isPaused;

    public GameState(boolean gameOver, boolean isPaused) {
        _gameOver = gameOver;
        _isPaused = isPaused;
    }

    @Override
    public boolean IsGameOver() {
        return _gameOver;
    }

    @Override
    public boolean IsPaused() {
        return _isPaused;
    }

    public void IsGameOver(boolean gameOver) {
        _gameOver = gameOver;
    }

    public void IsPaused(boolean isPaused) {
        _isPaused = isPaused;
    }
}
