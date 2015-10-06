package com.dkellycollins.triggerfinger.util;

public class MathUtil {

    public static float distanceSquared(float x1, float x2, float y1, float y2) {
        float x = x1 - x2;
        float y = y1 - y2;

        return x*x + y*y;
    }

}
