package com.solvd.library.services.myBatis;

import com.solvd.library.bin.Users;
import com.solvd.library.dao.IUserDAO;
import com.solvd.library.dao.impl.UsersDAO;
import com.solvd.library.services.UsersService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class UserServiceImpl implements UsersService {

    private final static Logger LOG = LogManager.getLogger(UserServiceImpl.class);


    @Override
    public void delete(Long id) {

    }

    @Override
    public void create(Users u) {

    }

    @Override
    public void update(Users entity) {

    }

    @Override
    public Users getUsers(Long id) {

        Reader e = null;
        try {
            e = Resources.getResourceAsReader("mybatisConfig.xml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        SqlSessionFactory sql = new SqlSessionFactoryBuilder().build(e);
        IUserDAO userDAO = sql.openSession().getMapper(IUserDAO.class);

        Users user =userDAO.getEntity(id);

        return user;
    }

    @Override
    public List<Users> getAllUsers() {

        Reader e = null;
        try {
            e = Resources.getResourceAsReader("mybatisConfig.xml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        SqlSessionFactory sql = new SqlSessionFactoryBuilder().build(e);
        IUserDAO userDAO = sql.openSession().getMapper(IUserDAO.class);
        List<Users> userList = userDAO.getAll();

        return userList;

    }
}
