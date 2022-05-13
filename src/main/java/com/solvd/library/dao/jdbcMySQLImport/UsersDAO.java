package com.solvd.library.dao.jdbcMySQLImport;

import com.solvd.library.classes.Users;
import com.solvd.library.dao.interfaces.IUserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsersDAO implements IUserDAO {

    final String INSERT = "INSERT INTO Users (id, name, email, address, age) VALUES (?, ?, ?, ?, ?)";
    final String UPDATE = "UPDATE Users SET name= ?, email= ?, address= ?, age=? WHERE id=?";
    final String DELETE = "DELETE from Users WHERE id=?";
    final String GETALL = "SELECT id, name, email, address, age FROM Users";
    final String GETONE = "SELECT id, name, email, address, age FROM Users WHERE id=?";

    private Connection conn;

    public UsersDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Users getEntity(Long id) {
        return null;
    }

    @Override
    public void saveEntity(Users u) {
        PreparedStatement pt = null;
        try {
            pt = conn.prepareStatement(INSERT);
            pt.setLong(1, u.getId());
            pt.setString(2, u.getName());
            pt.setString(3, u.getEmail());
            pt.setString(4, u.getAddress());
            pt.setInt(5, u.getAge());
            pt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pt != null) {
                try {
                    pt.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public void update(Users entity) {
    }

    @Override
    public void delete(Users id) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(DELETE);
            ps.setLong(1, id.getId());
            if (ps.executeUpdate() == 0) {
                throw new SQLException("Maybe it didn't erase the user");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Users> getAll() {


        return null;
    }


    public Users convert(ResultSet st) {
        String nam


    }
}
