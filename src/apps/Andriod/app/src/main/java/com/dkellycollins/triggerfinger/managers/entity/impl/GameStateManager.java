package com.dkellycollins.triggerfinger.managers.entity.impl;

import com.dkellycollins.triggerfinger.data.daos.IGameStateDao;
import com.dkellycollins.triggerfinger.data.entity.IGameState;
import com.dkellycollins.triggerfinger.managers.entity.IGameStateManager;
import com.dkellycollins.triggerfinger.util.qa.Assert;

public class GameStateManager implements IGameStateManager {

    private IGameStateDao _dao;

    public GameStateManager(IGameStateDao dao) {
        Assert.isNotNull(dao, "dao");

        _dao = dao;
    }

    @Override
    public IGameState retrieve() {
        return _dao.retrieve();
    }

    @Override
    public void TogglePause() {
        IGameState gameState = retrieve();

        _dao.update(gameState.IsGameOver(), !gameState.IsPaused());
    }

    @Override
    public void TogglePause(boolean isPaused) {
        IGameState gameState = retrieve();

        _dao.update(gameState.IsGameOver(), isPaused);
    }

    @Override
    public void SetGameOver() {
        IGameState gameState = retrieve();

        _dao.update(true, gameState.IsPaused());
    }

    @Override
    public void Reset() {
        _dao.update(false, false);
    }
}
