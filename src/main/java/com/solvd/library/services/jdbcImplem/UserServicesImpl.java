package com.solvd.library.services.jdbcImplem;

import com.solvd.library.bin.Users;
import com.solvd.library.dao.IUserDAO;
import com.solvd.library.dao.impl.UsersDAO;
import com.solvd.library.services.UsersService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.List;

public class UserServicesImpl implements UsersService {

    private static final Logger LOG = LogManager.getLogger(UserServicesImpl.class);


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
        Users user = userDAo.getEntity(id);

        return user;
    }

    @Override
    public List<Users> getAllUsers() {
        IUserDAO list = new UsersDAO();
        List<Users> userList = list.getAll();

        return userList;
    }
}

