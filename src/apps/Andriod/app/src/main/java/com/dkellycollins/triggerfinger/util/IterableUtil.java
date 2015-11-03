package com.dkellycollins.triggerfinger.util;

import java.util.ArrayList;

public class IterableUtil {

    public static <T> ArrayList<T> toArrayList(Iterable<T> iterable) {
        ArrayList<T> arrayList = new ArrayList<T>();
        for(T item : iterable) {
            arrayList.add(item);
        }

        return arrayList;
    }

}
