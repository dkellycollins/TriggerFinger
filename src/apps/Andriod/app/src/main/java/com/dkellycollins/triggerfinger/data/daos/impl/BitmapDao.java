package com.dkellycollins.triggerfinger.data.daos.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.dkellycollins.triggerfinger.data.daos.IBitmapDao;
import com.dkellycollins.triggerfinger.util.qa.Assert;

import java.util.HashMap;

public class BitmapDao implements IBitmapDao {

    private final Context _context;
    private final HashMap<Integer, Bitmap> _store;

    public BitmapDao(Context context) {
        Assert.isNotNull(context, "context");

        _context = context;
        _store = new HashMap<>();
    }

    @Override
    public void loadBitmap(int id) {
        Bitmap bitmap = BitmapFactory.decodeResource(_context.getResources(), id);
        _store.put(id, bitmap);
    }

    @Override
    public Bitmap retrieve(int id) {
        return _store.get(id);
    }

    @Override
    public void delete(int id) {
        Bitmap bitmap = _store.get(id);

        bitmap.recycle();

        _store.remove(id);
    }
}
