package com.solvd.library.dao.jdbcMySQLImport;

import com.solvd.library.classes.Users;
import com.solvd.library.dao.IUserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UsersDAO implements IUserDAO {

    final String INSERT = "INSERT INTO Users (id, name, email, address, age) VALUES (?, ?, ?, ?, ?)";

    private Connection conn;
    
    public UsersDAO(Connection conn){
        this.conn=conn;
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

    }

    @Override
    public List<Users> getAll() {
        return null;
    }
}
