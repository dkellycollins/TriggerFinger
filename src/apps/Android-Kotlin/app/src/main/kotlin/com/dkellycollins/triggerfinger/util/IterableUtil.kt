package com.dkellycollins.triggerfinger.util

import java.util.ArrayList

object IterableUtil {

    fun <T> toArrayList(iterable: Iterable<T>): ArrayList<T> {
        val arrayList = ArrayList<T>()
        for (item in iterable) {
            arrayList.add(item)
        }

        return arrayList
    }

}
