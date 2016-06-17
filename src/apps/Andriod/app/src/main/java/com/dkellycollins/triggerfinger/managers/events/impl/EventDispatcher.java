package com.dkellycollins.triggerfinger.managers.events.impl;

import com.dkellycollins.triggerfinger.managers.events.IEventDispatcher;
import com.dkellycollins.triggerfinger.managers.events.IEventInterceptor;
import com.dkellycollins.triggerfinger.managers.events.IMessage;

import java.util.List;

/**
 * Standard implementation of IEventDispatcher
 */
public class EventDispatcher implements IEventDispatcher {

    private final List<IEventInterceptor> _interceptors;

    public EventDispatcher(List<IEventInterceptor> interceptors) {
        _interceptors = interceptors;
    }

    @Override
    public <T extends IMessage> void dispatch(T message) {
        for (IEventInterceptor interceptor :_interceptors) {
            if(!interceptor.handlesMessage(message)) {
                continue;
            }

            interceptor.invoke(message);
        }
    }
}
