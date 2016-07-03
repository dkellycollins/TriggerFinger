package com.dkellycollins.triggerfinger.data.model.impl

import com.dkellycollins.triggerfinger.data.model.IVector

class Vector2 : IVector {

    override var x: Float = 0.toFloat()
    override var y: Float = 0.toFloat()
    override var length: Float = 0.toFloat()

    constructor() {
        x = 0f
        y = 0f
        length = 0f
    }

    constructor(x: Float, y: Float, length: Float) {
        this.x = x
        this.y = y
        this.length = length
    }

    override fun toString(): String {
        return "X: $x Y: $y Length: $length"
    }
}
