package com.dkellycollins.triggerfinger.managers.events;

/**
 * Sends a message throughout the system.
 */
public interface IEventDispatcher {

    <T extends IMessage> void dispatch(T message);
}
