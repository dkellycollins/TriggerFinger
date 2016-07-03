package com.dkellycollins.triggerfinger.data.config.impl

import android.content.Context

import com.dkellycollins.triggerfinger.R
import com.dkellycollins.triggerfinger.data.config.IFontConfig

class FontConfig(context: Context) : RConfig(context), IFontConfig {

    override val path: String
        get() = _context.resources.getString(R.string.font_path)

    override val size: Int
        get() = _context.resources.getInteger(R.integer.font_size)

    override val color: Int
        get() = _context.resources.getColor(R.color.font_color)
}
