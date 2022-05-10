package com.solvd.library.dao;

import java.util.List;

public interface IBaseDAO <T, K> {

    T getEntity (K id);
    void saveEntity(T entity);
    void update (T entity);
    void delete (T id);

    List<T> getAll();

}
