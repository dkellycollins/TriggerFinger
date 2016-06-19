package com.dkellycollins.triggerfinger.managers.events;

/**
 * Provides the ability to broadcast event data.
 */
public interface IEventDispatcher {

    /**
     * Broadcasts an event to the appropriate interceptors.
     * @param event The event data to send.
     * @param <T> The type of the event.
     */
    <T extends IEvent> void dispatch(T event);
}
