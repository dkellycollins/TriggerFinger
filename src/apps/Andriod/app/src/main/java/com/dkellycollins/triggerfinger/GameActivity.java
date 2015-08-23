package com.dkellycollins.triggerfinger;


import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class GameActivity extends Activity {

    private GameView _gameView;

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        _gameView = new GameView(this);
        setContentView(_gameView);
    }
}