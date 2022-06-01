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

public class BooksForSaleDAO extends AbsConnectionForDAO implements IBooksForSale {

    private final String GET_ALL = "SELECT id, name, editorial, price, booksId FROM BooksForSale";



    @Override
    public BooksForSale getEntity(Long id)  {
        throw new UnsupportedOperationException();
    }

    @Override
    public void saveEntity(BooksForSale entity)   {
        throw new UnsupportedOperationException();

    }

    @Override
    public void update(BooksForSale entity) {
        throw new UnsupportedOperationException();

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
    public void delete(Long id)   {
        throw new UnsupportedOperationException();

    }

    @Override
    public List<BooksForSale> getAll() throws ExceptionDAO {
        OneStepCloser closer = new OneStepCloser(null, null);
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn= getConnect();
        List<BooksForSale> bookss = new ArrayList<>();

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
