package com.dkellycollins.triggerfinger.data.daos

import com.dkellycollins.triggerfinger.data.entity.IGameState

/**
 * Provides the ability to manage game state data.
 */
interface IGameStateDao : IActivityDao {

    fun retrieve(): IGameState

    fun update(gameOver: Boolean, isPause: Boolean)
}
