package com.emrhmrc.motionsteel.javatesting;

public interface IEntityRepo<TEntity> {

    void add(TEntity entity);
    void delete(int i);
    void save();
    abstract TEntity getById(int i);
}
