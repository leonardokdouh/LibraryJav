package com.solvd.library.services.myBatis;

import com.solvd.library.bin.Users;
import com.solvd.library.dao.IUserDAO;
import com.solvd.library.services.UsersService;
import com.solvd.library.util.exceptions.ExceptionSQL;
import org.apache.ibatis.session.SqlSession;

import org.apache.ibatis.session.SqlSessionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;

public class UserServiceImplementation extends AbsSqlSession implements UsersService {

    private final static Logger LOG = LogManager.getLogger(UserServiceImplementation.class);


    @Override
    public void delete(Long id) {
        try (SqlSession session = sqlSession()) {
            IUserDAO userDAO = session.getMapper(IUserDAO.class);
            userDAO.delete(id);
            session.commit();
        }

    }

    @Override
    public void create(Users u) {
        try (SqlSession session = sqlSession()) {
            IUserDAO userDAO = session.getMapper(IUserDAO.class);
            userDAO.saveEntity(u);
            session.commit();
        }
    }

    @Override
    public void update(Users entity) {
        try (SqlSession session = sqlSession()) {
            IUserDAO userDAO = session.getMapper(IUserDAO.class);
            userDAO.update(entity);
            session.commit();
        }
    }

    @Override
    public Users getUsers(Long id) {
        try (SqlSession session = sqlSession()) {
            IUserDAO userDAO = session.getMapper(IUserDAO.class);
            Users user = userDAO.getEntity(id);
            return user;
        }
    }

    @Override
    public List<Users> getAllUsers() {
        try (SqlSession session = sqlSession()) {
            IUserDAO userDAO = session.getMapper(IUserDAO.class);
            List<Users> userList = userDAO.getAll();
            return userList;
        }
    }
}
