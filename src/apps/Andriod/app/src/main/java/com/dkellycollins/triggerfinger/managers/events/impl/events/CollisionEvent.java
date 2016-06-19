package com.dkellycollins.triggerfinger.managers.events.impl.events;

import com.dkellycollins.triggerfinger.managers.events.IEvent;

/**
 * Represents an event where two items collided.
 */
public class CollisionEvent implements IEvent {

    private final int _item1;
    private final int _item2;

    public CollisionEvent(int item1, int item2) {
        _item1 = item1;
        _item2 = item2;
    }

    public int getItem1() {
        return _item1;
    }

    public int getItem2() {
        return _item2;
    }
}
