package com.dkellycollins.triggerfinger.data.daos

import android.graphics.Bitmap

interface IBitmapDao {

    fun loadBitmap(id: Int)

    fun retrieve(id: Int): Bitmap

    fun delete(id: Int)

}
