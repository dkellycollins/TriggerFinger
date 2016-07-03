package com.dkellycollins.triggerfinger.managers.state

/**
 * Represents a manager that manages the state of the game.
 */
interface IStateManager {

    /**

     */
    fun init()

    /**
     * Called during the update phase.
     * @param deltaTime The time in milliseconds since the last update.
     */
    fun update(deltaTime: Long)
}
