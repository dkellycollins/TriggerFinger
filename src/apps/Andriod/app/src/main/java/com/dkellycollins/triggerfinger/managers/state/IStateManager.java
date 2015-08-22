package com.dkellycollins.triggerfinger.managers.state;

/**
 * Represents a manager that manages the state of the game.
 */
public interface IStateManager {

    /**
     *
     */
    void init();

    /**
     * Called during the update phase.
     * @param deltaTime The time in milliseconds since the last update.
     */
    void update(long deltaTime);
}
