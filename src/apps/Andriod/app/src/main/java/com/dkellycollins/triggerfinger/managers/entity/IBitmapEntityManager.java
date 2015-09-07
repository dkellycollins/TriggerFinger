package com.dkellycollins.triggerfinger.managers.entity;

import android.graphics.Bitmap;

public interface IBitmapEntityManager {

    Bitmap retrieve(int id);

    void load(int id);

    void delete(int id);

}
