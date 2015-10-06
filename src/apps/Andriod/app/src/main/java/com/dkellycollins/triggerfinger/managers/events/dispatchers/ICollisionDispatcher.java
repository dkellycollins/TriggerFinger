package com.dkellycollins.triggerfinger.managers.events.dispatchers;

import com.dkellycollins.triggerfinger.managers.events.interceptors.ICollisionInterceptor;

public interface ICollisionDispatcher {

    void onCollision(int item1, int item2);
}
