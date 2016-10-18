package com.dkellycollins.triggerfinger.managers.events.impl.interceptors.collisions;

import com.dkellycollins.triggerfinger.data.entity.IEnemy;
import com.dkellycollins.triggerfinger.data.entity.IPlayer;
import com.dkellycollins.triggerfinger.data.entity.ITimer;
import com.dkellycollins.triggerfinger.managers.entity.IEnemyEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IPlayerEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.ITimerEntityManager;
import com.dkellycollins.triggerfinger.managers.events.IEventInterceptor;
import com.dkellycollins.triggerfinger.managers.events.IEvent;
import com.dkellycollins.triggerfinger.managers.events.impl.events.CollisionEvent;
import com.dkellycollins.triggerfinger.util.qa.Assert;

public class PlayerEnemyCollisionInterceptor implements IEventInterceptor {

    private final IPlayerEntityManager _playerManager;
    private final IEnemyEntityManager _enemyManager;
    private final ITimerEntityManager _timerManager;

    public PlayerEnemyCollisionInterceptor(IPlayerEntityManager playerManager, IEnemyEntityManager enemyManager, ITimerEntityManager timerManager) {
        Assert.isNotNull(playerManager, "playerManager");
        Assert.isNotNull(enemyManager, "enemyManager");
        Assert.isNotNull(timerManager, "timerManager");

        _playerManager = playerManager;
        _enemyManager = enemyManager;
        _timerManager = timerManager;
    }

    @Override
    public boolean handlesMessage(IEvent event) {
        return event instanceof CollisionEvent;
    }

    @Override
    public void invoke(IEvent event) {
        CollisionEvent m = (CollisionEvent) event;

        IPlayer player = getPlayer(m.getItem1(), m.getItem2());
        IEnemy enemy = getEnemy(m.getItem1(), m.getItem2());

        if(player != null && enemy != null) {
            onCollision(player, enemy);
        }
    }

    public void onCollision(IPlayer player, IEnemy enemy) {

        ITimer invincibleTimer = _timerManager.retrieve(player.getInvincibleTimerId());
        if(invincibleTimer.isRunning()) {
           return;
        }

        byte health = (byte)(player.getHealth() - 1);

        _playerManager.update(player.getId(), player.getScore(), health);
        _timerManager.reset(player.getInvincibleTimerId());
        _timerManager.start(player.getInvincibleTimerId());
        _enemyManager.delete(enemy.getId());
    }

    private IPlayer getPlayer(int item1, int item2) {
        IPlayer player = _playerManager.retrievePlayerOne();

        if(player.getCollidableId() == item1 || player.getCollidableId() == item2) {
            return player;
        }
        return null;
    }

    private IEnemy getEnemy(int item1, int item2) {
        IEnemy enemy = _enemyManager.retrieveByCollidable(item1);
        if(enemy == null) {
            enemy = _enemyManager.retrieveByCollidable(item2);
        }

        return enemy;
    }
}
