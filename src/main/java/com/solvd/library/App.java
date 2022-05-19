package com.solvd.library;

import com.solvd.library.bin.Users;
import com.solvd.library.services.UsersService;
import com.solvd.library.services.impl.UserServicesImpl;
import com.solvd.library.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;

public class App {
    private static final Logger LOG = LogManager.getLogger(App.class);


    public static void main(String[] args) {

        try (Connection c = ConnectionPool.getInstance().getConnection()) {

            if (c != null) {
                LOG.info("You are inside now");
            } else {
                LOG.info("You did not Connect to the server");
            }

            // get 1 user method
            UsersService userGet = new UserServicesImpl(c);
            Users newUser = userGet.getUsers(3L);
            System.out.println(newUser.toString());

            // get all service method
            UsersService listUser = new UserServicesImpl(c);
            List <Users> thisList = listUser.getAllUsers();
            for (Users u : thisList){
                System.out.println(u.toString());
            }

            //Create user method
           /* UsersService up = new UserServicesImpl(c);
            Users lili = new Users("lili", "lili@gmail.com", "4th Av ", 55);
            lili.setId(14L);
            up.create(lili);
*/
            //Delete User
           /* UsersService down = new UserServicesImpl(c);
           down.delete(14L);
*/

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {

        }

    }
}
