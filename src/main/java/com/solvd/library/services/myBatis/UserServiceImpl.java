package com.solvd.library.services.myBatis;

import com.solvd.library.bin.Users;
import com.solvd.library.dao.IUserDAO;
import com.solvd.library.services.UsersService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserServiceImpl extends AbsSqlSession implements UsersService {

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
    public void update(Long id, Users entity) {
        try (SqlSession session = sqlSession()) {
            IUserDAO userDAO = session.getMapper(IUserDAO.class);
            userDAO.update(id, entity);
            session.commit();
        }
    }

    @Override
    public Users getUsers(Long id) {
        try (SqlSession session = sqlSession()) {
            IUserDAO userDAO = session.getMapper(IUserDAO.class);
            return userDAO.getEntity(id);
        }
    }

    @Override
    public List<Users> getAllUsers() {
        try (SqlSession session = sqlSession()) {
            IUserDAO userDAO = session.getMapper(IUserDAO.class);
            return userDAO.getAll();
        }
    }
}
