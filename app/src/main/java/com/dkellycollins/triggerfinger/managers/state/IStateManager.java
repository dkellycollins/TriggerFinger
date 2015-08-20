package com.dkellycollins.triggerfinger.managers.state;

/**
 * Represents a manager that manages the state of the game.
 */
public interface IStateManager {

    /**
     * Called during the update phase.
     * @param deltaTime The time since the last update.
     */
    void Update(int deltaTime);
}
