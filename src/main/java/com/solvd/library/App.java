package com.solvd.library;

import com.solvd.library.bin.Users;
import com.solvd.library.service.ConnectionPool;
import com.solvd.library.dao.interfaces.IUserDAO;
import com.solvd.library.dao.jdbcMySQLImport.UsersDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class App {
    private static final Logger LOG = LogManager.getLogger(App.class);

    public static void main(String[] args) {


        try (Connection c = ConnectionPool.getInstance().getConnection()) {
            Statement state = c.createStatement();

            ResultSet rs = state.executeQuery("select * from users");

            IUserDAO dao = new UsersDAO(c);
            Users newU = new Users(34L, "?", "?@gmail.com", "AV3  22", 1);
            dao.saveEntity(newU);

            if (c != null) {
                LOG.info("You are inside now");
            } else {
                LOG.info("You did not Connect to the server");
            }

            while (rs.next()) {
                LOG.info(rs.getString("name"));
            }
            rs.close();
            state.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
        }

    }
}
