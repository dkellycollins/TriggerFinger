package com.dkellycollins.triggerfinger.data.config.impl;

import android.content.Context;
import android.util.TypedValue;

public abstract class RConfig {

    protected final Context _context;

    protected RConfig(Context context) {
        _context = context;
    }

    protected float getFloat(int id) {
        TypedValue outValue = new TypedValue();
        _context.getResources().getValue(id, outValue, true);

        return outValue.getFloat();
    }

}
