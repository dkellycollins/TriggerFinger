package com.dkellycollins.ioc;

/**
 * Represents a class that can provide an instance of another class.
 */
public interface Provider<T> {

    /**
     * Returns an instance of the class.
     * @return
     */
    T getInstance();
}
