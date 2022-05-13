package com.solvd.library;

import com.solvd.library.classes.Users;
import com.solvd.library.util.ConnectionPool;
import com.solvd.library.dao.interfaces.IUserDAO;
import com.solvd.library.dao.jdbcMySQLImport.UsersDAO;

import java.sql.*;

public class App {
    public static void main(String[] args) {

        try (Connection c = ConnectionPool.getInstance().getConnection()) {
            Statement state = c.createStatement();

            ResultSet rs = state.executeQuery("select * from users");

            IUserDAO dao = new UsersDAO(c);
            Users newU = new Users(34L, "?", "?@gmail.com", "AV3  22", 1);
            dao.saveEntity(newU);

            if (c != null) {
                System.out.println("You are inside now");
            } else {
                System.out.println("You did not Connect to the server");
            }

            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

            rs.close();
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
