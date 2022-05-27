package com.solvd.library.dao.impl;

import com.solvd.library.bin.Workers;
import com.solvd.library.dao.IWorkersDAO;
import com.solvd.library.util.exceptions.ExceptionDAO;
import com.solvd.library.util.exceptions.ExceptionSQL;
import com.solvd.library.util.OneStepCloser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkersDAO implements IWorkersDAO {
    final String INSERT = "INSERT INTO Workers (name, gender, shifts) VALUES (?, ?, ?)";
    final String UPDATE = "UPDATE Workers SET name=?, gender=?, shifts=? WHERE id=?";
    final String DELETE = "DELETE from Workers WHERE id=?";
    final String GETONE = "SELECT id, name, gender, shifts FROM Workers WHERE id=?";
    final String GETALL = "SELECT id, name, gender, shifts FROM Workers";


    private Connection conn;

    public WorkersDAO(Connection conn) {
        this.conn = conn;
    }


    @Override
    public void saveEntity(Workers u) {

        PreparedStatement pt = null;
        try {
            pt = conn.prepareStatement(INSERT);
            pt.setString(1, u.getName());
            pt.setString(2, u.getGender());
            pt.setInt(3, u.getShifts());
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

        PreparedStatement ps = null;
        OneStepCloser close = new OneStepCloser(null);

        try {
            ps = conn.prepareStatement(UPDATE);

            ps.setString(1, entity.getName());
            ps.setString(2, entity.getGender());
            ps.setInt(3, entity.getShifts());

            if (ps.executeUpdate() == 0) {
                throw new ExceptionDAO("Maybe the update did not save");
            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Error in SQL", e);
        } finally {
            close.theCloser(ps);
        }
    }

    @Override
    public void delete(Long id) {

        PreparedStatement ps = null;

        OneStepCloser close = new OneStepCloser(ps);

        try {
            ps = conn.prepareStatement(DELETE);
            ps.setLong(1, id);

            if (ps.executeUpdate() == 0) {
                throw new ExceptionDAO("Not deleted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionSQL("Error in SQL");
        } finally {
            close.theCloser(ps);
        }
    }


    private Workers convert(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        String name = rs.getString("name");
        String gender = rs.getString("gender");
        int shifts = rs.getInt("shifts");

        Workers wrk = new Workers(name, gender, shifts);

        return wrk;
    }

    @Override
    public Workers getEntity(Long id) {
        OneStepCloser closer = new OneStepCloser(null, null);
        PreparedStatement ps = null;
        ResultSet rs = null;
        Workers wrk = null;

        try {
            ps = conn.prepareStatement(GETONE);
            rs = ps.executeQuery();

            if (rs.next()) {
                wrk = convert(rs);
            } else {
                throw new ExceptionDAO("Not work");
            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Can't reach the Worker", e);
        } finally {
            closer.twoCloser(ps, rs);
        }
        return wrk;
    }

    @Override
    public List<Workers> getAll() {

        OneStepCloser closer = new OneStepCloser(null, null);
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Workers> works = new ArrayList<>();

        try {
            ps = conn.prepareStatement(GETALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                works.add(convert(rs));
            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Can't reach the Worker", e);
        } finally {
            closer.twoCloser(ps, rs);
        }
        return works;
    }
}
