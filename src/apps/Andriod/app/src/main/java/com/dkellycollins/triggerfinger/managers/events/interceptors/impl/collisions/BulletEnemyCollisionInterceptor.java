package com.dkellycollins.triggerfinger.managers.events.interceptors.impl.collisions;

import com.dkellycollins.triggerfinger.data.entity.IBullet;
import com.dkellycollins.triggerfinger.data.entity.IEnemy;
import com.dkellycollins.triggerfinger.managers.entity.IBulletEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IEnemyEntityManager;
import com.dkellycollins.triggerfinger.managers.events.interceptors.ICollisionInterceptor;

public class BulletEnemyCollisionInterceptor implements ICollisionInterceptor {

    private final IBulletEntityManager _bulletManager;
    private final IEnemyEntityManager _enemyManager;

    public BulletEnemyCollisionInterceptor(IBulletEntityManager bulletManager, IEnemyEntityManager enemyManager) {
        _bulletManager = bulletManager;
        _enemyManager = enemyManager;
    }

    @Override
    public void onCollision(int item1, int item2) {
        IBullet bullet = getBullet(item1, item2);
        IEnemy enemy = getEnemy(item1, item2);

        if(bullet != null && enemy != null) {
            onCollision(bullet, enemy);
        }
    }

    public void onCollision(IBullet bullet, IEnemy enemy) {
        _bulletManager.delete(bullet.getId());
        _enemyManager.delete(enemy.getId());
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
