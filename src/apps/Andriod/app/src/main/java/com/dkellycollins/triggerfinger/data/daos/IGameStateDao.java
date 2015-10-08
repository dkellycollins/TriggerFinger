package com.dkellycollins.triggerfinger.data.daos;

import com.dkellycollins.triggerfinger.data.entity.IGameState;

public interface IGameStateDao {

    IGameState retrieve();

    void update(boolean gameOver, boolean isPause);
}
