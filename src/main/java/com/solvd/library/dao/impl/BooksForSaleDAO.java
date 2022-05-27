package com.solvd.library.dao.impl;

import com.solvd.library.bin.BooksForSale;
import com.solvd.library.dao.IBooksForSale;
import com.solvd.library.util.OneStepCloser;
import com.solvd.library.util.exceptions.ExceptionDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BooksForSaleDAO implements IBooksForSale {

    final String GETALL = "SELECT id, name, editorial, price, booksId FROM BooksForSale";


    private Connection conn;
    private static final Logger LOG = LogManager.getLogger(BooksDAO.class);

    public BooksForSaleDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public BooksForSale getEntity(Long id) throws ExceptionDAO {
        return null;
    }

    @Override
    public void saveEntity(BooksForSale entity) throws ExceptionDAO {

    }

    @Override
    public void update(BooksForSale entity) throws ExceptionDAO {

    }

    private BooksForSale convert(ResultSet rs) throws SQLException {
        String name = rs.getString("name");
        String editorial = rs.getString("editorial");
        int price = rs.getInt("price");
        Long booksId = rs.getLong("booksId");

        BooksForSale boks = new BooksForSale(name, editorial, price, booksId);
        boks.setId(rs.getLong("id"));

        return boks;
    }

    @Override
    public void delete(Long id) throws ExceptionDAO {

    }

    @Override
    public List<BooksForSale> getAll() throws ExceptionDAO {
        OneStepCloser closer = new OneStepCloser(null, null);
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<BooksForSale> bookss = new ArrayList<>();

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
