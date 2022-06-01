package com.solvd.library.services.myBatis;

import com.solvd.library.bin.Users;
import com.solvd.library.dao.IUserDAO;
import com.solvd.library.services.UsersService;
import com.solvd.library.util.Constants;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class UserServiceImpl extends AbsSqlSession implements UsersService {

    private final static Logger LOG = LogManager.getLogger(UserServiceImpl.class);


    @Override
    public void delete(Long id) {

            SqlSession session = sqlSession();
            IUserDAO userDAO = session.getMapper(IUserDAO.class);
            userDAO.delete(id);
            session.commit();
    }

    @Override
    public void create(Users u) {

            SqlSession session = sqlSession();
            IUserDAO userDAO = session.getMapper(IUserDAO.class);
            userDAO.saveEntity(u);
            session.commit();
    }

    @Override
    public void update(Users entity) {
        try {
            Reader e = Resources.getResourceAsReader("mybatisConfig.xml");
            SqlSessionFactory sql = new SqlSessionFactoryBuilder().build(e);
            IUserDAO userDAO = sql.openSession().getMapper(IUserDAO.class);

            userDAO.update(entity);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public Users getUsers(Long id) {
        SqlSession session = sqlSession();
        IUserDAO userDAO = session.getMapper(IUserDAO.class);

       Users user = userDAO.getEntity(id);

        return user;
    }

    @Override
    public List<Users> getAllUsers() {
        SqlSession session = sqlSession();

        IUserDAO userDAO = session.getMapper(IUserDAO.class);
        List<Users> userList = userDAO.getAll();

        return userList;

    }
}
