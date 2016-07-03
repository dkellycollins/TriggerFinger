package com.dkellycollins.triggerfinger.managers.events

/**
 * Provides the ability to intercept events.
 */
interface IEventInterceptor {

    /**
     * Indicates if the interceptor handles the provided event.
     * @param event The event to test.
     * *
     * @return True if the interceptor can handle the event. False otherwise.
     */
    fun handlesMessage(event: IEvent): Boolean

    /**
     * Invokes the interceptor with the provided event.

     * @param event The event.
     */
    operator fun invoke(event: IEvent)
}
