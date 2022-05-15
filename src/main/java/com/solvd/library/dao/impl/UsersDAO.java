package com.solvd.library.dao.impl;

import com.solvd.library.bin.Users;
import com.solvd.library.dao.IUserDAO;
import com.solvd.library.util.ExceptionDAO;

import java.lang.reflect.GenericArrayType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public void saveEntity(Users u) throws ExceptionDAO {
        PreparedStatement pt = null;
        try {
            pt = conn.prepareStatement(INSERT);
            pt.setLong(1, u.getId());
            pt.setString(2, u.getName());
            pt.setString(3, u.getEmail());
            pt.setString(4, u.getAddress());
            pt.setInt(5, u.getAge());

            if (pt.executeUpdate() == 0) {
                throw new ExceptionDAO("Maybe your users is not saved");
            }

        } catch (SQLException e) {
            throw new ExceptionDAO("Error in SQL sentence", e);
        } finally {
            if (pt != null) {
                try {
                    pt.close();
                } catch (SQLException e) {
                    throw new ExceptionDAO("Error in SQL sentence", e);
                }
            }
        }
    }

    @Override
    public void update(Users entity) throws ExceptionDAO {
        PreparedStatement ps = null;

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
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new ExceptionDAO("Error in SQL query", e);
                }

            }

        }


    }

    @Override
    public void delete(Users id) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(DELETE);
            ps.setLong(1, id.getId());
            if (ps.executeUpdate() == 0) {
                throw new SQLException("Maybe the User has not been deleted");
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
        Long id = rs.getLong("id");
        String name = rs.getString("name");
        String email = rs.getString("email");
        String address = rs.getString("address");
        int age = rs.getInt("age");

        Users user = new Users(id, name, email, address, age);
        user.setId(rs.getLong("id"));

        return user;
    }


    @Override
    public Users getEntity(Long id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Users u = null;
        try {
            ps = conn.prepareStatement(GETONE);
            rs =ps.executeQuery();
            if (rs.next()) {
                u = convert(rs);
            } else {
                throw new ExceptionDAO("that id isn't in our registry");
            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Error in SQL", e);
        } finally {
            if (rs != null || ps != null) {
                try {
                    rs.close();
                    ps.close();
                } catch (SQLException e) {
                    throw new ExceptionDAO("Error in SQL", e);
                }
            }
        }
        return u;
    }


    @Override
    public List<Users> getAll() {
        PreparedStatement ps = null;
        ResultSet rs= null;
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
            if (rs != null) {
                try {
                    rs.close();
                    ps.close();
                } catch (SQLException e) {
                    throw new ExceptionDAO("Error in SQL", e);
                }
            }
        }
        return users;
    }
}
