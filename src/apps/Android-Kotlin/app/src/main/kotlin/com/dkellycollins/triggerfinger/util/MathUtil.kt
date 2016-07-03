package com.dkellycollins.triggerfinger.util

object MathUtil {

    fun distanceSquared(x1: Float, x2: Float, y1: Float, y2: Float): Float {
        val x = x1 - x2
        val y = y1 - y2

        return x * x + y * y
    }

}
