package com.solvd.library.dao.impl;

import com.solvd.library.bin.Users;
import com.solvd.library.dao.IUserDAO;
import com.solvd.library.util.exceptions.ExceptionDAO;
import com.solvd.library.util.OneStepCloser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO implements IUserDAO {

    final String INSERT = "INSERT INTO Users (name, email, address, age) VALUES (?, ?, ?, ?)";
    final String UPDATE = "UPDATE Users SET name= ?, email= ?, address= ?, age=? WHERE id=?";
    final String DELETE = "DELETE from Users WHERE id=?";
    final String GETONE = "SELECT id, name, email, address, age FROM Users WHERE id=?";
    final String GETALL = "SELECT id, name, email, address, age FROM Users";

    private Connection conn;

    public UsersDAO(Connection conn) {
        this.conn = conn;
    }


    @Override
    public void saveEntity(Users u) throws ExceptionDAO {
        PreparedStatement ps = null;
        OneStepCloser end = new OneStepCloser(null);

        try {
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getAddress());
            ps.setInt(4, u.getAge());

            if (ps.executeUpdate() == 0) {
                throw new ExceptionDAO("Maybe your users is not saved");
            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Error in SQL sentence", e);

        } finally {
            end.theCloser(ps);
        }
    }

    @Override
    public void update(Users entity) throws ExceptionDAO {
        PreparedStatement ps = null;
        OneStepCloser end = new OneStepCloser(null);

        try {
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getEmail());
            ps.setString(3, entity.getAddress());
            ps.setInt(4, entity.getAge());

            if (ps.executeUpdate() == 0) {
                throw new ExceptionDAO("Maybe your changes may not be saved");
            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Error in SQL query", e);
        } finally {
            end.theCloser(ps);
        }
    }


    @Override
    public void delete(Long id) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(DELETE);
            ps.setLong(1, id);
            if (ps.executeUpdate() == 0) {
                throw new ExceptionDAO("Maybe the User has not been deleted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new ExceptionDAO("Error in SQL", e);
                }
            }
        }
    }

    private Users convert(ResultSet rs) throws SQLException {
        String name = rs.getString("name");
        String email = rs.getString("email");
        String address = rs.getString("address");
        int age = rs.getInt("age");
        Users user = new Users(name, email, address, age);
        user.setId(rs.getLong("id"));
        return user;
    }


    @Override
    public Users getEntity(Long id) {
        OneStepCloser closer = new OneStepCloser(null, null);
        PreparedStatement ps = null;
        ResultSet rs = null;
        Users user = null;
        try {
            ps = conn.prepareStatement(GETONE);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = convert(rs);
            } else {
                throw new ExceptionDAO("that id isn't in our registry");
            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Error in SQL", e);
        } finally {
            closer.twoCloser(ps, rs);
        }
        return user;
    }


    @Override
    public List<Users> getAll() {

        OneStepCloser closer = new OneStepCloser(null, null);

        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Users> users = new ArrayList<>();
        try {
            ps = conn.prepareStatement(GETALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                users.add(convert(rs));
            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Error in SQL", e);
        } finally {
            closer.twoCloser(ps, rs);
        }
        return users;
    }
}
