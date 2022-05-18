package com.solvd.library.dao.impl;

import com.solvd.library.bin.Books;
import com.solvd.library.dao.IBooksDao;
import com.solvd.library.util.ExceptionDAO;
import com.solvd.library.util.ExceptionSQL;
import com.solvd.library.util.OneStepCloser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BooksDAO implements IBooksDao {
//long id, name, type, Long cargoesID

    final String INSERT = "INSERT INTO Books (id, name, type, cargoesId) VALUES (?,?,?,?)";
    final String UPDATE = "UPDATE Books SET name =?, type=?, cargoesId= ?, WHERE id=?";
    final String DELETE = "DELETE from Books WHERE id=?";
    final String GETONE = "SELECT id, name, type, cargoesId, from Books WHERE id=?";
    final String GETALL = "SELECT id, name, type, cargoesId FROM Books";


    private Connection conn;

    public BooksDAO(Connection conn) {
        this.conn = conn;
    }


    @Override
    public void saveEntity(Books u) {

        PreparedStatement pt = null;
        try {
            pt = conn.prepareStatement(INSERT);
            pt.setLong(1, u.getId());
            pt.setString(2, u.getName());
            pt.setString(3, u.getType());
            pt.setLong(4, u.getCargoesId());
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
    public void update(Books entity) {
        PreparedStatement ps = null;
        OneStepCloser close = new OneStepCloser(null);

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


    private Books convert(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        String name = rs.getString("name");
        String type = rs.getString("type");
        Long cargoesId = rs.getLong("cargoesId");

        Books bok =new Books(id, name, type, cargoesId);

        return bok;
    }

    @Override
    public Books getEntity(Long id) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        Books bok;

        try {
            ps = conn.prepareStatement(GETONE);
            rs = ps.executeQuery();

            if (rs.next()) {
                bok = convert(rs);
            } else {
                throw new ExceptionDAO("Not work");
            }
            System.out.println("Inside the try");

        } catch (SQLException e) {
            throw new ExceptionDAO("Can't reach the Book", e);
        } finally {
            System.out.println("That's it");
        }
        return bok;
    }

    @Override
    public List<Books> getAll() {

        OneStepCloser closer = new OneStepCloser(null, null);
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Books> bookss = new ArrayList<>();

        try {
            ps = conn.prepareStatement(GETALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                bookss.add(convert(rs));
            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Can't reach the Worker", e);
        } finally {
            closer.twoCloser(ps, rs);
        }
        return bookss;
    }
}