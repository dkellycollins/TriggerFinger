package com.dkellycollins.triggerfinger.managers.entity.impl

import android.graphics.Bitmap

import com.dkellycollins.triggerfinger.data.daos.IBitmapDao
import com.dkellycollins.triggerfinger.managers.entity.IBitmapEntityManager

class BitmapEntityManager(private val _dao: IBitmapDao) : IBitmapEntityManager {

    override fun retrieve(id: Int): Bitmap {
        return _dao.retrieve(id)
    }

    override fun load(id: Int) {
        _dao.loadBitmap(id)
    }

    override fun delete(id: Int) {
        _dao.delete(id)
    }
}
