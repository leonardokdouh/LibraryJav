package com.solvd.library.dao.impl;

import com.solvd.library.bin.Workers;
import com.solvd.library.dao.IWorkersDAO;
import com.solvd.library.util.exceptions.ExceptionDAO;
import com.solvd.library.util.exceptions.ExceptionSQL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkersDAO extends AbsConnectionForDAO implements IWorkersDAO {
    private static final Logger LOG = LogManager.getLogger(WorkersDAO.class);

    private final String INSERT = "INSERT INTO Workers (name, gender, shifts) VALUES (?, ?, ?)";
    private final String UPDATE = "UPDATE Workers SET name=?, gender=?, shifts=? WHERE id=?";
    private final String DELETE = "DELETE from Workers WHERE id=?";
    private final String GET_ONE = "SELECT id, name, gender, shifts FROM Workers WHERE id=?";
    private final String GET_ALL = "SELECT id, name, gender, shifts FROM Workers";

    @Override
    public void saveEntity(Workers u) {
        PreparedStatement pt = null;
        Connection conn = getConnect();
        try {
            pt = conn.prepareStatement(INSERT);
            pt.setString(1, u.getName());
            pt.setString(2, u.getGender());
            pt.setInt(3, u.getShifts());
            pt.executeUpdate();
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
        } finally {
            returnConnect(conn);
            if (pt != null) {
                try {
                    pt.close();
                } catch (SQLException e) {
                    LOG.error("There was an error", e);
                }
            }
        }
    }

    @Override
    public void update(Long id, Workers entity) {
        PreparedStatement ps = null;
        Connection conn = getConnect();
        try {
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getGender());
            ps.setInt(3, entity.getShifts());
            ps.setLong(4, id);
            if (ps.executeUpdate() == 0) {
                throw new ExceptionDAO("Maybe the update did not save");
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Error in SQL");
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
                throw new ExceptionDAO("Not deleted");
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionSQL("Error in the query");
        } finally {
            returnConnect(conn);
            closeAllResources(ps);
        }
    }

    private Workers convert(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        String name = rs.getString("name");
        String gender = rs.getString("gender");
        int shifts = rs.getInt("shifts");
        Workers workers = new Workers(name, gender, shifts);
        return workers;
    }

    @Override
    public Workers getEntity(Long id) {
        PreparedStatement ps = null;
        Connection conn = getConnect();
        ResultSet rs = null;
        Workers worker;
        try {
            ps = conn.prepareStatement(GET_ONE);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                worker = convert(rs);
            } else {
                throw new ExceptionDAO("Not work");
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Can't reach the Worker");
        } finally {
            returnConnect(conn);
            closeAllResources(ps, rs);
        }
        return worker;
    }

    @Override
    public List<Workers> getAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConnect();
        List<Workers> works = new ArrayList<>();
        try {
            ps = conn.prepareStatement(GET_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                works.add(convert(rs));
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Can't reach the Worker");
        } finally {
            returnConnect(conn);
            closeAllResources(ps, rs);
        }
        return works;
    }
}
