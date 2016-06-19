package com.dkellycollins.triggerfinger.managers.events;

/**
 * Provides the ability to intercept events.
 */
public interface IEventInterceptor {

    /**
     * Indicates if the interceptor handles the provided event.
     * @param event The event to test.
     * @return True if the interceptor can handle the event. False otherwise.
     */
    boolean handlesMessage(IEvent event);

    /**
     * Invokes the interceptor with the provided event.
     *
     * @param event The event.
     */
    void invoke(IEvent event);
}
