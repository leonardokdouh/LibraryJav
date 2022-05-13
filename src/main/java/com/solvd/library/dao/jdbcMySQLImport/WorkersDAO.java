package com.solvd.library.dao.jdbcMySQLImport;

import com.solvd.library.bin.Workers;
import com.solvd.library.dao.interfaces.IWorkersDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class WorkersDAO implements IWorkersDAO {
    final String INSERT = "INSERT INTO Users (id, name, gender, shifts) VALUES (?, ?, ?, ?)";

    private Connection conn;

    public WorkersDAO(Connection conn){
        this.conn=conn;
    }


    @Override
    public Workers getEntity(Long id) {
        return null;
    }

    @Override
    public void saveEntity(Workers u) {

            PreparedStatement pt = null;
            try {
                pt = conn.prepareStatement(INSERT);
                pt.setLong(1, u.getId());
                pt.setString(2, u.getName());
                pt.setString(3, u.getGender());
                pt.setString(4, u.toString());
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
    public void update(Workers entity) {

    }

    @Override
    public void delete(Workers id) {

    }

    @Override
    public List<Workers> getAll() {
        return null;
    }
}
