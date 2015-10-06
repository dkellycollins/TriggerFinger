package com.dkellycollins.triggerfinger.data.config.impl;

import android.content.Context;

import com.dkellycollins.triggerfinger.R;
import com.dkellycollins.triggerfinger.data.config.IFontConfig;

public class FontConfig extends RConfig implements IFontConfig {

    public FontConfig(Context context) {
        super(context);
    }

    @Override
    public String getPath() {
        return _context.getResources().getString(R.string.font_path);
    }

    @Override
    public int getSize() {
        return _context.getResources().getInteger(R.integer.font_size);
    }

    @Override
    public int getColor() {
        return _context.getResources().getColor(R.color.font_color);
    }
}
