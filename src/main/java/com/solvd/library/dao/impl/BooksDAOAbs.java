package com.solvd.library.dao.impl;

import com.solvd.library.bin.Books;
import com.solvd.library.dao.IBooksDao;
import com.solvd.library.util.exceptions.ExceptionDAO;
import com.solvd.library.util.exceptions.ExceptionSQL;
import com.solvd.library.util.OneStepCloser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BooksDAOAbs extends AbsConnectionForDAO implements IBooksDao {

    private final String INSERT = "INSERT INTO Books (name, type, cargoesId) VALUES (?,?,?)";
    private final String UPDATE = "UPDATE Books SET name =?, type=?, cargoesId= ?, WHERE id=?";
    private final String DELETE = "DELETE from Books WHERE id=?";
    private final String GET_ONE = "SELECT id, name, type, cargoesId, from Books WHERE id=?";
    private final String GET_ALL = "SELECT id, name, type, cargoesId FROM Books";


    private static final Logger LOG = LogManager.getLogger(BooksDAOAbs.class);

    @Override
    public void saveEntity(Books u) {

        PreparedStatement pt = null;
        Connection conn = getConnect();
        try {
            pt = conn.prepareStatement(INSERT);
            pt.setString(1, u.getName());
            pt.setString(2, u.getType());
            pt.setLong(3, u.getCargoesId());
            pt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            returnConnect(conn);
            if (pt != null) {
                try {
                    pt.close();
                } catch (SQLException e) {
                }
            }
        }
    }


    @Override
    public void update(Books entity) {
        PreparedStatement ps = null;
        OneStepCloser close = new OneStepCloser(null);
        Connection conn = getConnect();


        try {
            ps = conn.prepareStatement(UPDATE);

            ps.setString(1, entity.getName());
            ps.setString(2, entity.getType());
            ps.setLong(3, entity.getCargoesId());

            if (ps.executeUpdate() == 0) {
                throw new ExceptionDAO("Maybe the update did not save");
            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Error in SQL", e);
        } finally {
            returnConnect(conn);

            close.theCloser(ps);
        }
    }

    @Override
    public void delete(Long id) {

        PreparedStatement ps = null;
        OneStepCloser close = new OneStepCloser(ps);
        Connection conn = getConnect();


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
            returnConnect(conn);

            close.theCloser(ps);
        }
    }


    private Books convert(ResultSet rs) throws SQLException {
        String name = rs.getString("name");
        String type = rs.getString("type");
        Long cargoesId = rs.getLong("cargoesId");

        Books bok = new Books(name, type, cargoesId);
        bok.setId(rs.getLong("id"));

        return bok;
    }

    @Override
    public Books getEntity(Long id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConnect();

        Books bok;

        try {
            ps = conn.prepareStatement(GET_ONE);
            rs = ps.executeQuery();

            if (rs.next()) {
                bok = convert(rs);
            } else {
                throw new ExceptionDAO("Not work");
            }

        } catch (SQLException e) {
            throw new ExceptionDAO("Can't reach the Book", e);
        } finally {
            returnConnect(conn);
        }
        return bok;
    }

    @Override
    public List<Books> getAll() {

        OneStepCloser closer = new OneStepCloser(null, null);
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConnect();
        List<Books> bookss = new ArrayList<>();

        try {
            ps = conn.prepareStatement(GET_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                bookss.add(convert(rs));
            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Can't reach the Worker", e);
        } finally {
            returnConnect(conn);

            closer.twoCloser(ps, rs);
        }
        return bookss;
    }
}