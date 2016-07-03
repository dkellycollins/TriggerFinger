package com.dkellycollins.triggerfinger.managers.events

/**
 * Provides the ability to broadcast event data.
 */
interface IEventDispatcher {

    /**
     * Broadcasts an event to the appropriate interceptors.
     * @param event The event data to send.
     * *
     * @param  The type of the event.
     */
    fun <T : IEvent> dispatch(event: T)
}
