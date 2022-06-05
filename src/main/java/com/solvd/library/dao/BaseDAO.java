package com.solvd.library.dao;

import com.solvd.library.util.exceptions.ExceptionDAO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDAO<T, K> {

    T getEntity(K id) throws ExceptionDAO;

    void saveEntity(T entity) throws ExceptionDAO;

    void update(@Param("id")K id, @Param("ent")T entity) throws ExceptionDAO;

    void delete(K id) throws ExceptionDAO;

    List<T> getAll() throws ExceptionDAO;

}
