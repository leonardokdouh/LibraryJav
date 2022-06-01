package com.solvd.library.services.jdbcImplem;

import com.solvd.library.bin.BooksForLend;
import com.solvd.library.dao.IBooksForLend;
import com.solvd.library.dao.impl.BooksForLendDAO;
import com.solvd.library.services.BooksForLendsService;

import java.sql.Connection;
import java.util.List;

public class BooksForLendImpl implements BooksForLendsService {



    @Override
    public List<BooksForLend> getAllBooks() {
        IBooksForLend bokLend = new BooksForLendDAO();
        List<BooksForLend> lendsList = bokLend.getAll();
        return lendsList;
    }
}
