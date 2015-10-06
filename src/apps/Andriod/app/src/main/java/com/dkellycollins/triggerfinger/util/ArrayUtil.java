package com.dkellycollins.triggerfinger.util;

import java.util.ArrayList;

public class ArrayUtil {

    public static <T> ArrayList<T> asArrayList(Iterable<T> iterable) {
        ArrayList<T> arrayList = new ArrayList<T>();
        for(T item : iterable) {
            arrayList.add(item);
        }

        return arrayList;
    }

}
