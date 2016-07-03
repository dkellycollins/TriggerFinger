package com.dkellycollins.triggerfinger.data.config.impl

import android.content.Context
import android.util.TypedValue

abstract class RConfig protected constructor(protected val _context: Context) {

    protected fun getFloat(id: Int): Float {
        val outValue = TypedValue()
        _context.resources.getValue(id, outValue, true)

        return outValue.float
    }

}
