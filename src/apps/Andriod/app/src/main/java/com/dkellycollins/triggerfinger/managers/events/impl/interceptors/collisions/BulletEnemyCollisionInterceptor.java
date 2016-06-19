package com.dkellycollins.triggerfinger.managers.events.impl.interceptors.collisions;

import com.dkellycollins.triggerfinger.data.entity.IBullet;
import com.dkellycollins.triggerfinger.data.entity.IEnemy;
import com.dkellycollins.triggerfinger.data.entity.IPlayer;
import com.dkellycollins.triggerfinger.managers.entity.IBulletEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IEnemyEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IPlayerEntityManager;
import com.dkellycollins.triggerfinger.managers.events.IEventInterceptor;
import com.dkellycollins.triggerfinger.managers.events.IEvent;
import com.dkellycollins.triggerfinger.managers.events.impl.events.CollisionEvent;

public class BulletEnemyCollisionInterceptor implements IEventInterceptor {

    private final IBulletEntityManager _bulletManager;
    private final IEnemyEntityManager _enemyManager;
    private final IPlayerEntityManager _playerManager;

    public BulletEnemyCollisionInterceptor(IBulletEntityManager bulletManager, IEnemyEntityManager enemyManager, IPlayerEntityManager playerManager) {
        _bulletManager = bulletManager;
        _enemyManager = enemyManager;
        _playerManager = playerManager;
    }

    @Override
    public boolean handlesMessage(IEvent event) {
        return event instanceof CollisionEvent;
    }

    @Override
    public void invoke(IEvent event) {
        CollisionEvent m = (CollisionEvent) event;

        IBullet bullet = getBullet(m.getItem1(), m.getItem2());
        IEnemy enemy = getEnemy(m.getItem1(), m.getItem2());

        if(bullet != null && enemy != null) {
            onCollision(bullet, enemy);
        }
    }

    public void onCollision(IBullet bullet, IEnemy enemy) {
        _bulletManager.delete(bullet.getId());
        _enemyManager.delete(enemy.getId());

        IPlayer player = _playerManager.retrievePlayerOne();
        if(player != null) {
            _playerManager.update(player.getId(), player.getScore() + 50, player.getHealth());
        }
    }

    private IBullet getBullet(int item1, int item2) {
        IBullet bullet = _bulletManager.retrieveByCollidable(item1);
        if(bullet == null) {
            bullet = _bulletManager.retrieveByCollidable(item2);
        }

        return bullet;
    }

    private IEnemy getEnemy(int item1, int item2) {
        IEnemy enemy = _enemyManager.retrieveByCollidable(item1);
        if(enemy == null) {
            enemy = _enemyManager.retrieveByCollidable(item2);
        }

        return enemy;
    }
}
