package com.solvd.library.dao.impl;

import com.solvd.library.bin.BooksForLend;
import com.solvd.library.bin.BooksForSale;
import com.solvd.library.dao.IBooksForLend;
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

public class BooksforLendDAO implements IBooksForLend {

    final String GETALL = "SELECT id, name, editorial, ESN,  days, booksId FROM BooksForLend";


    private Connection conn;
    private static final Logger LOG = LogManager.getLogger(BooksDAO.class);

    public BooksforLendDAO(Connection conn){
        this.conn=conn;
    }



    @Override
    public BooksForLend getEntity(Long id) throws ExceptionDAO {
        return null;
    }

    @Override
    public void saveEntity(BooksForLend entity) throws ExceptionDAO {

    }

    @Override
    public void update(BooksForLend entity) throws ExceptionDAO {

    }

    @Override
    public void delete(Long id) throws ExceptionDAO {

    }


    private BooksForLend convert(ResultSet rs) throws SQLException {
        String name = rs.getString("name");
        String editorial = rs.getString("editorial");
        int esn = rs.getInt("esn");
        int days=rs.getInt("days");
        Long booksId = rs.getLong("booksId");

        BooksForLend boks = new BooksForLend(name, editorial, esn, days, booksId);
        boks.setId(rs.getLong("id"));

        return boks;
    }

    @Override
    public List<BooksForLend> getAll() throws ExceptionDAO {
        OneStepCloser closer = new OneStepCloser(null, null);
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<BooksForLend> bookss = new ArrayList<>();

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