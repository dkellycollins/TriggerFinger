package com.dkellycollins.triggerfinger.managers.events.interceptors.impl.collisions;

import com.dkellycollins.triggerfinger.data.entity.IBullet;
import com.dkellycollins.triggerfinger.data.entity.IPlayer;
import com.dkellycollins.triggerfinger.managers.entity.IBulletEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.IPlayerEntityManager;
import com.dkellycollins.triggerfinger.managers.events.interceptors.ICollisionInterceptor;

public class BulletPlayerCollisionInterceptor implements ICollisionInterceptor {

    private final IBulletEntityManager _bulletManager;
    private final IPlayerEntityManager _playerManager;

    public BulletPlayerCollisionInterceptor(IBulletEntityManager bulletManager, IPlayerEntityManager playerManager) {
        _bulletManager = bulletManager;
        _playerManager = playerManager;
    }


    @Override
    public void OnCollision(int item1, int item2) {
        IPlayer player = getPlayer(item1, item2);
        IBullet bullet = getBullet(item1, item2);

        if(player != null && bullet != null) {
            onCollision(bullet, player);
        }
    }

    public void onCollision(IBullet bullet, IPlayer player) {
        _bulletManager.delete(bullet.getId());
    }

    private IPlayer getPlayer(int item1, int item2) {
        IPlayer player = _playerManager.retrievePlayerOne();

        if(player.getCollidableId() == item1 || player.getCollidableId() == item2) {
            return player;
        }
        return null;
    }

    private IBullet getBullet(int item1, int item2) {
        IBullet bullet = _bulletManager.retrieveByCollidable(item1);
        if(bullet == null) {
            bullet = _bulletManager.retrieveByCollidable(item2);
        }

        return bullet;
    }
}
