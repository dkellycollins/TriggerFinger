package com.dkellycollins.triggerfinger.managers.events.impl

import com.dkellycollins.triggerfinger.managers.events.IEventDispatcher
import com.dkellycollins.triggerfinger.managers.events.IEventInterceptor
import com.dkellycollins.triggerfinger.managers.events.IEvent

/**
 * Standard implementation of IEventDispatcher
 */
class EventDispatcher(private val _interceptors: List<IEventInterceptor>) : IEventDispatcher {

    override fun <T : IEvent> dispatch(event: T) {
        for (interceptor in _interceptors) {
            if (!interceptor.handlesMessage(event)) {
                continue
            }

            interceptor.invoke(event)
        }
    }
}
