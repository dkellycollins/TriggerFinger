package com.dkellycollins.triggerfinger.managers.events.impl;

import com.dkellycollins.triggerfinger.managers.events.IEventDispatcher;
import com.dkellycollins.triggerfinger.managers.events.IEventInterceptor;
import com.dkellycollins.triggerfinger.managers.events.IEvent;

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
    public <T extends IEvent> void dispatch(T event) {
        for (IEventInterceptor interceptor :_interceptors) {
            if(!interceptor.handlesMessage(event)) {
                continue;
            }

            interceptor.invoke(event);
        }
    }
}
