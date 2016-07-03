package com.dkellycollins.triggerfinger.managers.events.impl.events

import com.dkellycollins.triggerfinger.managers.events.IEvent

/**
 * Represents an event where two items collided.
 */
class CollisionEvent(val item1: Int, val item2: Int) : IEvent
