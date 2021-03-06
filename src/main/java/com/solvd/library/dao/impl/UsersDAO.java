package com.solvd.library.dao.impl;

import com.solvd.library.bin.Users;
import com.solvd.library.dao.IUserDAO;
import com.solvd.library.util.exceptions.ExceptionDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO extends AbsConnectionForDAO implements IUserDAO {
    private static final Logger LOG = LogManager.getLogger(UsersDAO.class);

    private final String INSERT = "INSERT INTO Users (name, email, address, age) VALUES (?, ?, ?, ?)";
    private final String UPDATE = "UPDATE Users SET name=?, email=?, address=?, age=? WHERE id=?";
    private final String DELETE = "DELETE from Users WHERE id=?";
    private final String GET_ONE = "SELECT id, name, email, address, age FROM Users WHERE id=?";
    private final String GET_ALL = "SELECT id, name, email, address, age FROM Users";


    @Override
    public void saveEntity(Users u) {
        PreparedStatement ps = null;
        Connection conn = getConnect();
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
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Error in SQL sentence");
        } finally {
            returnConnect(conn);
            closeAllResources(ps);
        }
    }

    @Override
    public void update(Long id, Users entity) {
        PreparedStatement ps = null;
        Connection conn = getConnect();
        try {
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getEmail());
            ps.setString(3, entity.getAddress());
            ps.setInt(4, entity.getAge());
            ps.setLong(5, id);
            if (ps.executeUpdate() == 0) {
                throw new ExceptionDAO("Maybe your changes may not be saved");
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Error in SQL query");
        } finally {
            returnConnect(conn);
            closeAllResources(ps);
        }
    }


    @Override
    public void delete(Long id) {
        PreparedStatement ps = null;
        Connection conn = getConnect();
        try {
            ps = conn.prepareStatement(DELETE);
            ps.setLong(1, id);
            if (ps.executeUpdate() == 0) {
                throw new ExceptionDAO("Maybe the User has not been deleted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            returnConnect(conn);
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    LOG.error("Error in SQL", e);
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
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConnect();
        Users user;
        try {
            ps = conn.prepareStatement(GET_ONE);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = convert(rs);
            } else {
                throw new ExceptionDAO("that id isn't in our registry");
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Error in SQL");
        } finally {
            returnConnect(conn);
            closeAllResources(ps, rs);
        }
        return user;
    }

    @Override
    public List<Users> getAll() {
        PreparedStatement ps = null;
        Connection conn = getConnect();
        ResultSet rs = null;
        List<Users> users = new ArrayList<>();
        try {
            ps = conn.prepareStatement(GET_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                users.add(convert(rs));
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Error in SQL");
        } finally {
            returnConnect(conn);
            closeAllResources(ps, rs);
        }
        return users;
    }
}
