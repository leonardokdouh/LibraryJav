package com.solvd.library.dao.impl;

import com.solvd.library.bin.BooksForLend;
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

public class BooksForLendDAO extends AbsConnectionForDAO implements IBooksForLend {
    private static final Logger LOG = LogManager.getLogger(BooksForLendDAO.class);


    private final String GET_ALL = "SELECT id, name, editorial, ESN,  days, booksId FROM BooksForLend";


    @Override
    public BooksForLend getEntity(Long id) {
        throw new UnsupportedOperationException("No implementation yet");
    }

    @Override
    public void saveEntity(BooksForLend entity) {
        throw new UnsupportedOperationException("No implementation yet");

    }

    @Override
    public void update(Long id, BooksForLend entity) {
        throw new UnsupportedOperationException("No implementation yet");

    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("No implementation yet");

    }


    private BooksForLend convert(ResultSet rs) throws SQLException {
        String name = rs.getString("name");
        String editorial = rs.getString("editorial");
        int esn = rs.getInt("esn");
        int days = rs.getInt("days");
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
        Connection conn = getConnect();

        List<BooksForLend> bookss = new ArrayList<>();

        try {
            ps = conn.prepareStatement(GET_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                bookss.add(convert(rs));
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Can't reach the Worker");
        } finally {
            closer.twoCloser(ps, rs);
            returnConnect(conn);
        }
        return bookss;
    }
}
