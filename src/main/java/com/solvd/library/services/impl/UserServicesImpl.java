package com.solvd.library.services.impl;

import com.solvd.library.bin.Users;
import com.solvd.library.dao.IUserDAO;
import com.solvd.library.dao.impl.UsersDAO;
import com.solvd.library.services.UsersService;

import java.sql.Connection;
import java.util.List;

public class UserServicesImpl implements UsersService {

    private Connection conn;

    public UserServicesImpl(Connection conn) {
        this.conn = conn;
    }


    @Override
    public void delete(Long id) {
        IUserDAO userDAo = new UsersDAO(conn);
        userDAo.delete(id);
    }

    @Override
    public void create(Users u) {
        IUserDAO userDAo = new UsersDAO(conn);
        userDAo.saveEntity(u);
    }

    @Override
    public void update(Users entity) {

        IUserDAO userDAo = new UsersDAO(conn);
        userDAo.update(entity);
    }

    @Override
    public Users getUsers(Long id) {

        IUserDAO userDAo = new UsersDAO(conn);
        Users user = userDAo.getEntity(id);

        return user;
    }

    @Override
    public List<Users> getAllUsers() {
        IUserDAO list = new UsersDAO(conn);
        List<Users> userList = list.getAll();

        return userList;
    }
}

