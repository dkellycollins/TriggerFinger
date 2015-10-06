package com.dkellycollins.triggerfinger.managers.events.dispatchers.impl;

import com.dkellycollins.triggerfinger.managers.events.dispatchers.ICollisionDispatcher;
import com.dkellycollins.triggerfinger.managers.events.interceptors.ICollisionInterceptor;

public class CollisionDispatcher implements ICollisionDispatcher {

    private final Iterable<ICollisionInterceptor> _interceptors;

    public CollisionDispatcher(Iterable<ICollisionInterceptor> interceptors) {
        _interceptors = interceptors;
    }

    public void onCollision(int item1, int item2) {
        for(ICollisionInterceptor interceptor : _interceptors) {
            interceptor.onCollision(item1, item2);
        }
    }
}
