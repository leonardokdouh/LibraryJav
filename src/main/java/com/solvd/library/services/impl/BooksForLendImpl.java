package com.solvd.library.services.impl;

import com.solvd.library.bin.BooksForLend;
import com.solvd.library.bin.BooksForSale;
import com.solvd.library.dao.IBooksForLend;
import com.solvd.library.dao.IBooksForSale;
import com.solvd.library.dao.impl.BooksForSaleDAO;
import com.solvd.library.dao.impl.BooksforLendDAO;
import com.solvd.library.services.BooksForLendsService;

import java.sql.Connection;
import java.util.List;

public class BooksForLendImpl implements BooksForLendsService {

    private Connection conn;

    public BooksForLendImpl(Connection conn){
        this.conn=conn;
    }

    @Override
    public List<BooksForLend> getAllBooks() {
        IBooksForLend bokLend = new BooksforLendDAO(conn);
        List<BooksForLend> lendsList = bokLend.getAll();
        return lendsList;
    }
}
