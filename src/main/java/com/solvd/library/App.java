package com.solvd.library;

import com.solvd.library.Util.ConnectionPool;
import com.solvd.library.dao.IUserDAO;
import com.solvd.library.dao.jdbcMySQLImport.UsersDAO;

import java.sql.*;

public class App {
    public static void main(String[] args){

        try (Connection c = ConnectionPool.getInstance().getConnection()) {
            Statement state = c.createStatement();

            ResultSet rs = state.executeQuery("select * from users");

            IUserDAO dao = new UsersDAO(c);

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
            ConnectionPool.getInstance().closeConnection(c);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    }

  /*SAVE THIS TO introduce a new user!
            Statement state = connection.createStatement();
            Users newU = new Users(34L,"FEDE", "fede@f.com", "AV3  22", 40);
            dao.saveEntity(newU);
*/

