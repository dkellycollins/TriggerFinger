package com.dkellycollins.triggerfinger.data.daos;

import android.graphics.Bitmap;

public interface IBitmapDao {

    void loadBitmap(int id);

    Bitmap retrieve(int id);

    void delete(int id);

}
