package com.dkellycollins.triggerfinger.data.daos.impl

import android.os.Bundle

import com.dkellycollins.triggerfinger.data.daos.IActivityDao

import java.io.Serializable
import java.util.HashMap

abstract class BaseEntityDao<T> protected constructor(private val _bundleId: String) : IActivityDao {
    protected val _store: HashMap<Int, T>

    init {
        _store = HashMap<Int, T>()
    }

    protected val nextId: Int
        get() = NEXT_ID++

    override fun saveState(bundle: Bundle) {
        bundle.putSerializable(_bundleId, _store)
    }

    override fun restoreState(bundle: Bundle) {
        _store.clear()

        if (bundle == null) {
            return
        }

        val savedStore = bundle.getSerializable(_bundleId)
        if (savedStore != null && savedStore is HashMap<Any, Any>) {
            val s = savedStore as HashMap<Int, T>
            _store.putAll(s)
        }
    }

    companion object {

        private var NEXT_ID = 0
    }
}