package com.dkellycollins.triggerfinger.managers.events.interceptors.impl.collisions;

import com.dkellycollins.triggerfinger.data.entity.IEnemy;
import com.dkellycollins.triggerfinger.data.entity.IPlayer;
import com.dkellycollins.triggerfinger.managers.entity.IEnemyEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IPlayerEntityManager;
import com.dkellycollins.triggerfinger.managers.events.interceptors.ICollisionInterceptor;

public class PlayerEnemyCollisionInterceptor implements ICollisionInterceptor {

    private final IPlayerEntityManager _playerManager;
    private final IEnemyEntityManager _enemyManager;

    public PlayerEnemyCollisionInterceptor(IPlayerEntityManager playerManager, IEnemyEntityManager enemyManager) {
        _playerManager = playerManager;
        _enemyManager = enemyManager;
    }

    @Override
    public void onCollision(int item1, int item2) {
        IPlayer player = getPlayer(item1, item2);
        IEnemy enemy = getEnemy(item1, item2);

        if(player != null && enemy != null) {
            onCollision(player, enemy);
        }
    }

    public void onCollision(IPlayer player, IEnemy enemy) {
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
