package com.dkellycollins.triggerfinger.managers.entity.impl;

import com.dkellycollins.triggerfinger.daos.IEntityDao;
import com.dkellycollins.triggerfinger.entity.ICollidable;
import com.dkellycollins.triggerfinger.entity.impl.Collidable;
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager;
import com.dkellycollins.triggerfinger.model.IPosition;

public class CollidableEntityManager extends BaseEntityManager implements ICollidableEntityManager {

    private final IEntityDao<ICollidable> _dao;

    public CollidableEntityManager(IEntityDao<ICollidable> dao) {
        _dao = dao;
    }

    @Override
    public Iterable<ICollidable> getAll() {
        return _dao.getAll();
    }

    @Override
    public ICollidable get(int id) {
        return _dao.get(id);
    }

    @Override
    public int create(IPosition position, float radius) {
        ICollidable entity = new Collidable(getNextId(), position, radius);

        return _dao.create(entity);
    }

    @Override
    public void update(int id, IPosition position, float radius) {
        Collidable entity = (Collidable) _dao.get(id);

        entity.setCenter(position);
        entity.setRadius(radius);
    }

    @Override
    public void delete(int id) {
        _dao.delete(id);
    }
}
