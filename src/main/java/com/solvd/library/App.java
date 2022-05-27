package com.solvd.library;

import com.solvd.library.dao.IUserDAO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class App {
    private static final Logger LOG = LogManager.getLogger(App.class);


    public static void main(String[] args) throws IOException {



        Reader e = Resources.getResourceAsReader("mybatisConfig.xml");
        SqlSessionFactory sql = new SqlSessionFactoryBuilder().build(e);
        IUserDAO userdao = sql.openSession().getMapper(IUserDAO.class);


/*
        String resource = "mybatisConfig.xml";
        System.out.println(resource);

        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sql = new SqlSessionFactoryBuilder().build(inputStream);
        List<Users> uses = sql.openSession().selectList("com.solvd.LibraryJav.dao.IUserDAO.getAll");

        System.out.println(uses);*/
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
