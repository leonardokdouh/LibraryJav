package com.solvd.library.dao;

import com.solvd.library.util.ExceptionDAO;

import java.util.List;

public interface IBaseDAO<T, K> {

    T getEntity(K id) throws ExceptionDAO;

    void saveEntity(T entity) throws ExceptionDAO;

    void update(T entity) throws ExceptionDAO;

    void delete(T id) throws ExceptionDAO;

    List<T> getAll() throws ExceptionDAO;

}
