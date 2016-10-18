package com.dkellycollins.triggerfinger.data.daos.impl;

import android.os.Bundle;

import com.dkellycollins.triggerfinger.data.daos.IActivityDao;
import com.dkellycollins.triggerfinger.util.qa.Assert;

import java.io.Serializable;
import java.util.HashMap;

public abstract class BaseEntityDao<T> implements IActivityDao {

    private static int NEXT_ID = 0;

    private final String _bundleId;
    protected final HashMap<Integer, T> _store;

    protected BaseEntityDao(String bundleId) {
        Assert.isNotNullOrEmpty(bundleId, "bundleId");

        _bundleId = bundleId;
        _store = new HashMap<>();
    }

    protected int getNextId() {
        return NEXT_ID++;
    }

    public void saveState(Bundle bundle) {
        bundle.putSerializable(_bundleId, _store);
    }

    public void restoreState(Bundle bundle) {
        _store.clear();

        if(bundle == null) {
            return;
        }

        Serializable savedStore = bundle.getSerializable(_bundleId);
        if(savedStore != null && savedStore instanceof HashMap) {
            HashMap<Integer, T> s = (HashMap<Integer, T>)savedStore;
            _store.putAll(s);
        }
    }
}