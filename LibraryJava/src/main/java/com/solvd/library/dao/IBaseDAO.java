package com.solvd.library.dao;

public interface IBaseDAO <T> {

    T getEntity (Long id);
    void saveEntity(T entity);
    void update (T entity);
    void delete (Long id);

}
