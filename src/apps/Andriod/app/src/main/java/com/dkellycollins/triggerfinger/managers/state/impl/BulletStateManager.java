package com.dkellycollins.triggerfinger.managers.state.impl;

import com.dkellycollins.triggerfinger.data.daos.IDeviceInfoDao;
import com.dkellycollins.triggerfinger.data.entity.IBullet;
import com.dkellycollins.triggerfinger.data.entity.ICollidable;
import com.dkellycollins.triggerfinger.data.model.IVector;
import com.dkellycollins.triggerfinger.data.model.impl.Vector2;
import com.dkellycollins.triggerfinger.managers.entity.IBulletEntityManager;
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager;
import com.dkellycollins.triggerfinger.managers.state.IStateManager;

import java.util.ArrayList;
import java.util.List;

public class BulletStateManager implements IStateManager {

    private final IBulletEntityManager _bulletManager;
    private final ICollidableEntityManager _collidableManager;
    private final IDeviceInfoDao _deviceInfo;
    private final List<Integer> _toRemove;

    public BulletStateManager(IBulletEntityManager bulletManager, ICollidableEntityManager collidableManager, IDeviceInfoDao deviceInfo) {
        _bulletManager = bulletManager;
        _collidableManager = collidableManager;
        _deviceInfo = deviceInfo;
        _toRemove = new ArrayList<>();
    }

    @Override
    public void init() {

    }

    @Override
    public void update(long deltaTime) {

        for(IBullet bullet : _bulletManager.retrieve()) {
            ICollidable collidable = _collidableManager.retrieve(bullet.getCollidableId());

            int maxX = _deviceInfo.getWidth();
            int maxY = _deviceInfo.getHeight();
            IVector center = collidable.getCenter();

            if(center.getX() < 0 || center.getX() > maxX) {
                _toRemove.add(bullet.getId());
            }
            else if(center.getY() < 0 || center.getY() > maxY) {
                _toRemove.add(bullet.getId());
            }
            else {
                IVector velocity = bullet.getVelocity();

                float dX = velocity.getX() * velocity.getLength() * ((float)deltaTime / 1000);
                float dY = velocity.getY() * velocity.getLength() * ((float)deltaTime / 1000);
                _collidableManager.update(collidable.getId(), new Vector2(center.getX() + dX, center.getY() + dY, 0), collidable.getRadius());
            }
        }

        for(Integer id : _toRemove) {
            _bulletManager.delete(id);
        }
        _toRemove.clear();
    }
}
