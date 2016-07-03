package com.dkellycollins.triggerfinger


import android.app.Activity
import android.os.Bundle
import android.view.Window

import com.dkellycollins.triggerfinger.data.daos.IActivityDao

class GameActivity : Activity() {

    private var _gameView: GameView? = null
    var module: Module? = null
        private set

    public override fun onCreate(savedInstance: Bundle?) {
        super.onCreate(savedInstance)

        _gameView = GameView(this)
        module = Module(_gameView, this)

        for (dao in module!!.activityDaos) {
            dao.restoreState(savedInstance)
        }

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(_gameView)
    }

    public override fun onSaveInstanceState(savedInstanceState: Bundle) {
        if (module == null) {
            return
        }

        for (dao in module!!.activityDaos) {
            dao.saveState(savedInstanceState)
        }
    }
}