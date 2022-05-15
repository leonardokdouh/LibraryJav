package com.solvd.library;

import com.solvd.library.bin.Users;
import com.solvd.library.util.ConnectionPool;
import com.solvd.library.dao.IUserDAO;
import com.solvd.library.dao.impl.UsersDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;

public class App {
    private static final Logger LOG = LogManager.getLogger(App.class);

    public static void main(String[] args) {


        try (Connection c = ConnectionPool.getInstance().getConnection()) {
            IUserDAO user = new UsersDAO(c);
            List<Users> users = user.getAll();
            for (Users u : users){
                System.out.println(u.toString());
            }

            if (c != null) {
                LOG.info("You are inside now");
            } else {
                LOG.info("You did not Connect to the server");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
        }

    }
}
