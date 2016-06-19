package com.dkellycollins.triggerfinger.data.daos;

import com.dkellycollins.triggerfinger.data.entity.IGameState;

/**
 * Provides the ability to manage game state data.
 */
public interface IGameStateDao extends IActivityDao {

    IGameState retrieve();

    void update(boolean gameOver, boolean isPause);
}
