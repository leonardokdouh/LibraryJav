package com.solvd.library.services.impl;

import com.solvd.library.bin.Books;
import com.solvd.library.dao.IBooksDao;
import com.solvd.library.dao.impl.BooksDAO;
import com.solvd.library.services.BooksService;

import java.sql.Connection;

public class BooksServiceImp implements BooksService {

    private Connection conn;

    public BooksServiceImp(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Books getBooks(Long id) {

        IBooksDao bokDao = new BooksDAO(conn);

        Books boks = null;

        boks = bokDao.getEntity(id);

        return boks;
    }
}
