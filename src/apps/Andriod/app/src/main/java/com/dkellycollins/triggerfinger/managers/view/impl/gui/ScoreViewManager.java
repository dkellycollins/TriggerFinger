package com.dkellycollins.triggerfinger.managers.view.impl.gui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import com.dkellycollins.triggerfinger.data.config.IFontConfig;
import com.dkellycollins.triggerfinger.data.entity.IPlayer;
import com.dkellycollins.triggerfinger.data.model.ViewLayer;
import com.dkellycollins.triggerfinger.managers.entity.IPlayerEntityManager;
import com.dkellycollins.triggerfinger.managers.view.IViewManager;
import com.dkellycollins.triggerfinger.util.qa.Assert;

public class ScoreViewManager implements IViewManager {

    private final Context _context;
    private final IFontConfig _fontConfig;
    private final IPlayerEntityManager _playerManager;

    private Paint _paint;

    public ScoreViewManager(Context context, IFontConfig fontConfig, IPlayerEntityManager playerManager) {
        Assert.isNotNull(context, "context");
        Assert.isNotNull(fontConfig, "fontConfig");
        Assert.isNotNull(playerManager, "playerManager");

        _context = context;
        _fontConfig = fontConfig;
        _playerManager = playerManager;
    }

    @Override
    public ViewLayer getLayer() {
        return ViewLayer.GUI;
    }

    @Override
    public void init() {
        Typeface typeface = Typeface.createFromAsset(_context.getAssets(),_fontConfig.getPath());

        _paint = new Paint();
        _paint.setColor(_fontConfig.getColor());
        _paint.setStyle(Paint.Style.FILL);
        _paint.setTextSize(_fontConfig.getSize());
        _paint.setTypeface(typeface);
    }

    @Override
    public void render(Canvas canvas) {
        IPlayer player = _playerManager.retrievePlayerOne();
        if(player == null) {
            return;
        }

        String score = String.valueOf(player.getScore());
        canvas.drawText(score, 100, 100, _paint);
    }

    @Override
    public void dispose() {

    }
}
