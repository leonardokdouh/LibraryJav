package com.solvd.library.services.jdbcImplem;

import com.solvd.library.bin.BooksForLend;
import com.solvd.library.dao.IBooksForLend;
import com.solvd.library.dao.impl.BooksForLendDAO;
import com.solvd.library.services.BooksForLendsService;

import java.util.List;

public class BooksForLendServiceImpl implements BooksForLendsService {
    @Override
    public List<BooksForLend> getAllBooks() {
        IBooksForLend bokLend = new BooksForLendDAO();
        return bokLend.getAll();
    }
}
