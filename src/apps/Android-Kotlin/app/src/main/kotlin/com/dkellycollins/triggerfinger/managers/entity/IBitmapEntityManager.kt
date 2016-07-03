package com.dkellycollins.triggerfinger.managers.entity

import android.graphics.Bitmap

interface IBitmapEntityManager {

    fun retrieve(id: Int): Bitmap

    fun load(id: Int)

    fun delete(id: Int)

}
