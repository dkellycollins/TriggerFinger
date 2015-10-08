package com.dkellycollins.triggerfinger.managers.entity;

import com.dkellycollins.triggerfinger.data.entity.IGameState;

public interface IGameStateManager {

    IGameState retrieve();

    void TogglePause();

    void TogglePause(boolean isPaused);

    void SetGameOver();

    void Reset();

}
