package com.dkellycollins.triggerfinger.data.daos.impl;

import android.os.Bundle;

import com.dkellycollins.triggerfinger.data.daos.IGameStateDao;
import com.dkellycollins.triggerfinger.data.entity.IGameState;
import com.dkellycollins.triggerfinger.data.entity.impl.GameState;

import java.io.Serializable;

public class GameStateDao implements IGameStateDao {

    private static final String BUNDLE_ID = "GameStateDao";
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

    @Override
    public void saveState(Bundle bundle) {
        bundle.putSerializable(BUNDLE_ID, _gameState);
    }

    @Override
    public void restoreState(Bundle bundle) {
        _gameState.IsGameOver(false);
        _gameState.IsPaused(false);

        if(bundle == null) {
            return;
        }

        Serializable saveState = bundle.getSerializable(BUNDLE_ID);
        if(saveState != null && saveState instanceof GameState) {
            GameState gs = (GameState)saveState;
            _gameState.IsGameOver(gs.IsGameOver());
            _gameState.IsPaused(gs.IsPaused());
        }
    }
}
