package com.dkellycollins.triggerfinger.managers.events.dispatchers.impl;

import com.dkellycollins.triggerfinger.managers.events.ICollisionEvent;
import com.dkellycollins.triggerfinger.managers.events.dispatchers.ICollisionDispatcher;

public class CollisionEventDispatcher implements ICollisionDispatcher {

    private final Iterable<ICollisionEvent> _interceptors;

    public CollisionEventDispatcher(Iterable<ICollisionEvent> interceptors) {
        _interceptors = interceptors;
    }

    public void onCollision(int item1, int item2) {
        for(ICollisionEvent interceptor : _interceptors) {
            interceptor.onCollision(item1, item2);
        }
    }
}
