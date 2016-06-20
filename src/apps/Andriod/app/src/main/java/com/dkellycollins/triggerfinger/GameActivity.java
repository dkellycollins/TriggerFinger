package com.dkellycollins.triggerfinger;


import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class GameActivity extends Activity {

    private GameView _gameView;
    private Module _module;

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        _gameView = new GameView(this);
        _module = new Module(_gameView, this);

        setContentView(_gameView);
    }

    public Module getModule() {
        return _module;
    }
}