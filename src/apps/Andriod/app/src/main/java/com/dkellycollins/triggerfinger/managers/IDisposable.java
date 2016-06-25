package com.dkellycollins.triggerfinger.managers;

/**
 * Provides the ability to dispose of resources held by a class.
 */
public interface IDisposable {

    /**
     * Disposes of all un-managed resources held by a class.
     */
    void dispose();
}
