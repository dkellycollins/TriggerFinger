package com.dkellycollins.triggerfinger.daos;

import com.dkellycollins.triggerfinger.entity.IEntity;

import java.util.List;

public interface IEntityDao<T extends IEntity> {

    Iterable<T> getAll();

    T get(int id);

    int create(T toCreate);

    void delete(int id);
}