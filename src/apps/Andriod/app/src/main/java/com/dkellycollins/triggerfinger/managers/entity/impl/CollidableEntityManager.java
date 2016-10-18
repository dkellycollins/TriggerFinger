package com.dkellycollins.triggerfinger.managers.entity.impl;

import com.dkellycollins.triggerfinger.data.daos.ICollidableDao;
import com.dkellycollins.triggerfinger.data.entity.ICollidable;
import com.dkellycollins.triggerfinger.managers.entity.ICollidableEntityManager;
import com.dkellycollins.triggerfinger.data.model.IVector;
import com.dkellycollins.triggerfinger.util.qa.Assert;

public class CollidableEntityManager implements ICollidableEntityManager {

    private final ICollidableDao _dao;

    public CollidableEntityManager(ICollidableDao dao) {
        Assert.isNotNull(dao, "dao");

        _dao = dao;
    }

    @Override
    public Iterable<ICollidable> retrieve() {
        return _dao.retrieve();
    }

    @Override
    public ICollidable retrieve(int id) {
        return _dao.retrieve(id);
    }

    @Override
    public int create(IVector position, float radius) {
        return _dao.create(position, radius);
    }

    @Override
    public void update(int id, IVector position, float radius) {
        _dao.update(id, position, radius);
    }

    @Override
    public void delete(int id) {
        _dao.delete(id);
    }
}
