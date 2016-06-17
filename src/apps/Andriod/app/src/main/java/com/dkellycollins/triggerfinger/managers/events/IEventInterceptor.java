package com.dkellycollins.triggerfinger.managers.events;

/**
 * Handles an event with a message of type T.
 */
public interface IEventInterceptor {

    /**
     * Indicates if the interceptor handles the provided message.
     * @param message The message to test.
     * @return True if the interceptor can handle the message. False otherwise.
     */
    boolean handlesMessage(IMessage message);

    /**
     * Invokes the interceptor with the provided message.
     *
     * @param message The event message.
     */
    void invoke(IMessage message);
}
