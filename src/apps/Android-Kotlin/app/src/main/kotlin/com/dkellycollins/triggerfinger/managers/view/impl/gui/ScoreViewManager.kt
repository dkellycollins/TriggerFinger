package com.dkellycollins.triggerfinger.managers.view.impl.gui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface

import com.dkellycollins.triggerfinger.data.config.IFontConfig
import com.dkellycollins.triggerfinger.data.entity.IPlayer
import com.dkellycollins.triggerfinger.data.model.ViewLayer
import com.dkellycollins.triggerfinger.managers.entity.IPlayerEntityManager
import com.dkellycollins.triggerfinger.managers.view.IViewManager

class ScoreViewManager(private val _context: Context, private val _fontConfig: IFontConfig, private val _playerManager: IPlayerEntityManager) : IViewManager {

    private var _paint: Paint? = null

    override val layer: ViewLayer
        get() = ViewLayer.GUI

    override fun init() {
        val typeface = Typeface.createFromAsset(_context.assets, _fontConfig.path)

        _paint = Paint()
        _paint!!.color = _fontConfig.color
        _paint!!.style = Paint.Style.FILL
        _paint!!.textSize = _fontConfig.size.toFloat()
        _paint!!.typeface = typeface
    }

    override fun render(canvas: Canvas) {
        val player = _playerManager.retrievePlayerOne() ?: return

        val score = player.score.toString()
        canvas.drawText(score, 100f, 100f, _paint!!)
    }

    override fun dispose() {

    }
}
