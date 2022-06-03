package com.solvd.library.services.jdbcImplem;

import com.solvd.library.bin.BooksForLend;
import com.solvd.library.dao.IBooksForLend;
import com.solvd.library.dao.impl.BooksForLendDAO;
import com.solvd.library.services.BooksForLendsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class BooksForLendServiceImpl implements BooksForLendsService {

    private static final Logger LOG = LogManager.getLogger(BooksForLendServiceImpl.class);


    @Override
    public List<BooksForLend> getAllBooks() {
        IBooksForLend bokLend = new BooksForLendDAO();
        List<BooksForLend> lendsList = bokLend.getAll();
        return lendsList;
    }
}
