package com.dkellycollins.triggerfinger.data.daos.impl

import android.view.View

import com.dkellycollins.triggerfinger.data.daos.IDeviceInfoDao

class DeviceInfoDao(private val _view: View) : IDeviceInfoDao {

    override val width: Int
        get() = _view.width

    override val height: Int
        get() = _view.height
}
