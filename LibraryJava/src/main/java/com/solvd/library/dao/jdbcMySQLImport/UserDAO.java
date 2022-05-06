package com.solvd.library.dao.jdbcMySQLImport;

import com.solvd.library.dao.IUserDAO;

public class UserDAO implements IUserDAO {
    @Override
    public BooksDAO getEntity(Long id) {
        return null;
    }

    @Override
    public void saveEntity(BooksDAO entity) {

    }

    @Override
    public void update(BooksDAO entity) {

    }

    @Override
    public void delete(Long id) {

    }
}
