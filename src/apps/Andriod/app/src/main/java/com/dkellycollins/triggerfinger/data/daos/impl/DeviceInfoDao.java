package com.dkellycollins.triggerfinger.data.daos.impl;

import android.view.View;

import com.dkellycollins.triggerfinger.data.daos.IDeviceInfoDao;

public class DeviceInfoDao implements IDeviceInfoDao {

    private final View _view;

    public DeviceInfoDao(View view) {
        _view = view;
    }

    @Override
    public int getWidth() {
        return _view.getWidth();
    }

    @Override
    public int getHeight() {
        return _view.getHeight();
    }
}
