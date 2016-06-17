package com.dkellycollins.triggerfinger.managers.events.impl.messages;

import com.dkellycollins.triggerfinger.managers.events.IMessage;

/**
 * Created by Devin on 6/17/2016.
 */
public class CollisionMessage implements IMessage {

    private final int _item1;
    private final int _item2;

    public CollisionMessage(int item1, int item2) {
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
