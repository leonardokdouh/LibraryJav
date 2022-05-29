package com.solvd.library;

import com.solvd.library.bin.Users;
import com.solvd.library.dao.IUserDAO;
import com.solvd.library.services.UsersService;
import com.solvd.library.services.jdbcImplem.UserServicesImpl;
import com.solvd.library.services.myBatis.UserServiceImpl;
import com.solvd.library.util.ConnectionPool;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.sql.Connection;
import java.util.List;

public class App {
    private static final Logger LOG = LogManager.getLogger(App.class);


    public static void main(String[] args) throws IOException {
        Connection c = ConnectionPool.getInstance().getConnection();

        UsersService userJdbc = new UserServicesImpl(c);

        LOG.info(userJdbc.getUsers(3L).toString());

        LOG.info(userJdbc.getAllUsers());


        try {
            UserServiceImpl userMyBatis = new UserServiceImpl();
            LOG.error(userMyBatis.getUsers(3L).toString());
            LOG.info(userMyBatis.getAllUsers());
        }catch (Exception e){
            LOG.error(e);
        }

        //user.getAllUsers();


        /*List <Users> theList = userDAO.getAll();
        for (Users u : theList) {
            LOG.info(u.toString());
        }*
           /*
        List<Users> thisList = listUser.getAllUsers();
        for (Users u : thisList){
            LOG.info(u.toString());*/

        }
 }

     /*
        try (Connection c = ConnectionPool.getInstance().getConnection()) {

            if (c != null) {
                LOG.info("You are inside now");
            } else {
                LOG.info("You did not Connect to the server");
            }

            holis.creation();

            // get all service method
            UsersService listUser = new UserServicesImpl(c);
            List <Users> thisList = listUser.getAllUsers();
            for (Users u : thisList){
                LOG.info(u.toString());
            }

            // get 1 user method
            UsersService userGet = new UserServicesImpl(c);
            Users newUser = userGet.getUsers(3L);
            LOG.info(newUser.toString());

            //Create user method
            UsersService up = new UserServicesImpl(c);
            Users lili = new Users("Mery", "mery@gmail.com", "4th Av ", 55);
            up.create(lili);
            LOG.info("THe new user was created with id: ");

            //Delete User
            UsersService down = new UserServicesImpl(c);
           down.delete(14L);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {

        }

    }
}*/
