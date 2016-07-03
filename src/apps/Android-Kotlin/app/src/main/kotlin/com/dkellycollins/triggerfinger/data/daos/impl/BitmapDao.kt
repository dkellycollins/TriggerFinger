package com.dkellycollins.triggerfinger.data.daos.impl

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory

import com.dkellycollins.triggerfinger.data.daos.IBitmapDao

import java.util.HashMap

class BitmapDao(private val _context: Context) : IBitmapDao {
    private val _store: HashMap<Int, Bitmap>

    init {
        _store = HashMap<Int, Bitmap>()
    }

    override fun loadBitmap(id: Int) {
        val bitmap = BitmapFactory.decodeResource(_context.resources, id)
        _store.put(id, bitmap)
    }

    override fun retrieve(id: Int): Bitmap {
        return _store[id]
    }

    override fun delete(id: Int) {
        val bitmap = _store[id]

        bitmap.recycle()

        _store.remove(id)
    }
}
