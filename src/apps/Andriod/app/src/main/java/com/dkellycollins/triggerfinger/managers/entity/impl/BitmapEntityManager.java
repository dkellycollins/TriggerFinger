package com.dkellycollins.triggerfinger.managers.entity.impl;

import android.graphics.Bitmap;

import com.dkellycollins.triggerfinger.data.daos.IBitmapDao;
import com.dkellycollins.triggerfinger.managers.entity.IBitmapEntityManager;
import com.dkellycollins.triggerfinger.util.qa.Assert;

public class BitmapEntityManager implements IBitmapEntityManager {

    private final IBitmapDao _dao;

    public BitmapEntityManager(IBitmapDao dao) {
        Assert.isNotNull(dao, "dao");

        _dao = dao;
    }

    @Override
    public Bitmap retrieve(int id) {
        return _dao.retrieve(id);
    }

    @Override
    public void load(int id) {
        _dao.loadBitmap(id);
    }

    @Override
    public void delete(int id) {
        _dao.delete(id);
    }
}
