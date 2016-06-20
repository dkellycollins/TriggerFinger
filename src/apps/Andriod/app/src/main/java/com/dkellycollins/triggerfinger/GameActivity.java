package com.dkellycollins.triggerfinger;


import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.dkellycollins.triggerfinger.data.daos.IActivityDao;

import java.util.List;

public class GameActivity extends Activity {

    private GameView _gameView;
    private Module _module;

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        _gameView = new GameView(this);
        _module = new Module(_gameView, this);

        for(IActivityDao dao : _module.getActivityDaos()) {
            dao.restoreState(savedInstance);
        }

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(_gameView);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        if(_module == null) {
            return;
        }

        for(IActivityDao dao : _module.getActivityDaos()) {
            dao.saveState(savedInstanceState);
        }
    }

    public Module getModule() {
        return _module;
    }
}