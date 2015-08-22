package com.dkellycollins.triggerfinger;


import android.app.Activity;
import android.os.Bundle;
import android.view.SurfaceView;

import com.dkellycollins.triggerfinger.daos.IEntityDao;
import com.dkellycollins.triggerfinger.daos.ITouchPositionDao;
import com.dkellycollins.triggerfinger.daos.impl.EntityDao;
import com.dkellycollins.triggerfinger.daos.impl.TouchPositionDao;
import com.dkellycollins.triggerfinger.entity.ICollidable;
import com.dkellycollins.triggerfinger.entity.IEntity;
import com.dkellycollins.triggerfinger.entity.IPlayer;
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IPlayerEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.impl.CollidableEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.impl.PlayerEntityManager;
import com.dkellycollins.triggerfinger.managers.state.IStateManager;
import com.dkellycollins.triggerfinger.managers.state.impl.PlayerStateManager;
import com.dkellycollins.triggerfinger.managers.view.IViewManager;
import com.dkellycollins.triggerfinger.managers.view.impl.PlayerViewManager;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends Activity {

    private GameThread _gameThread;

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        setContentView(R.layout.game_activity);


    }

    @Override
    public void onDestroy() {
        _gameThread.setActive(false);
    }

    protected SurfaceView getView() {
        return (SurfaceView) findViewById(R.id.game_view);
    }
}