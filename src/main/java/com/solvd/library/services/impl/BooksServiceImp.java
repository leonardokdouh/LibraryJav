package com.solvd.library.services.impl;

import com.solvd.library.bin.Books;
import com.solvd.library.dao.IBooksDao;
import com.solvd.library.dao.impl.BooksDAO;
import com.solvd.library.services.BooksService;

import java.sql.Connection;
import java.util.List;

public class BooksServiceImp implements BooksService {

    private Connection conn;

    private IBooksDao boks = new BooksDAO(conn);

    public BooksServiceImp(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Books getBooks(Long id) {
        Books book = boks.getEntity(id);
        return book;
    }

    @Override
    public void delete(Long id) {
        boks.delete(id);
    }

    @Override
    public void update(Books u) {
        boks.update(u);
    }

    @Override
    public void create(Books u) {
        boks.saveEntity(u);
    }

    @Override
    public List<Books> getallBooks() {

        List<Books> booksList = boks.getAll();
        return booksList;
    }
}
