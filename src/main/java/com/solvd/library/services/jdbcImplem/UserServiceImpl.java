package com.solvd.library.services.jdbcImplem;

import com.solvd.library.bin.Users;
import com.solvd.library.dao.IUserDAO;
import com.solvd.library.dao.impl.UsersDAO;
import com.solvd.library.services.UsersService;

import java.util.List;

public class UserServiceImpl implements UsersService {

    @Override
    public void delete(Long id) {
        IUserDAO userDAo = new UsersDAO();
        userDAo.delete(id);
    }

    @Override
    public void create(Users u) {
        IUserDAO userDAo = new UsersDAO();
        userDAo.saveEntity(u);
    }

    @Override
    public void update(Long id, Users entity) {
        IUserDAO userDAo = new UsersDAO();
        userDAo.update(id, entity);
    }

    @Override
    public Users getUsers(Long id) {
        IUserDAO userDAo = new UsersDAO();
        return userDAo.getEntity(id);
    }

    @Override
    public List<Users> getAllUsers() {
        IUserDAO list = new UsersDAO();
        return list.getAll();
    }
}

