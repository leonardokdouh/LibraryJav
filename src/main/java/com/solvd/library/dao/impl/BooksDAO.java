package com.solvd.library.dao.impl;

import com.solvd.library.bin.Books;
import com.solvd.library.dao.IBooksDao;
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

public class BooksDAO extends AbsConnectionForDAO implements IBooksDao {

    private final String INSERT = "INSERT INTO Books (name, type, cargoesId) VALUES (?,?,?)";
    private final String UPDATE = "UPDATE Books SET name =?, type=?, cargoesId= ? WHERE id=?";
    private final String DELETE = "DELETE from Books WHERE id=?";
    private final String GET_ONE = "SELECT id, name, type, cargoesId from Books WHERE id=?";
    private final String GET_ALL = "SELECT id, name, type, cargoesId FROM Books";

    private static final Logger LOG = LogManager.getLogger(BooksDAO.class);

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
                    LOG.error("Error in SQL", e);
                }
            }
        }
    }

    @Override
    public void update(Long id, Books entity) {
        PreparedStatement ps = null;
        Connection conn = getConnect();
        try {
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getType());
            ps.setLong(3, entity.getCargoesId());
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
            throw new ExceptionSQL("Error in SQL");
        } finally {
            returnConnect(conn);
            closeAllResources(ps);
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
        Books books;
        try {
            ps = conn.prepareStatement(GET_ONE);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                books = convert(rs);
            } else {
                throw new ExceptionDAO("Not work");
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Can't reach the Book");
        } finally {
            returnConnect(conn);
        }
        return books;
    }

    @Override
    public List<Books> getAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConnect();
        List<Books> listOfBooks = new ArrayList<>();
        try {
            ps = conn.prepareStatement(GET_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                listOfBooks.add(convert(rs));
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Can't reach the Worker");
        } finally {
            returnConnect(conn);
            closeAllResources(ps, rs);
        }
        return listOfBooks;
    }
}