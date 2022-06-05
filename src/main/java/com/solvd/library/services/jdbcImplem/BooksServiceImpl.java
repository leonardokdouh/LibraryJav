package com.solvd.library.services.jdbcImplem;

import com.solvd.library.bin.Books;
import com.solvd.library.dao.IBooksDao;
import com.solvd.library.dao.impl.BooksDAO;
import com.solvd.library.services.BooksService;

import java.util.List;

public class BooksServiceImpl implements BooksService {

    @Override
    public Books getBooks(Long id) {
        IBooksDao books = new BooksDAO();
        return books.getEntity(id);
    }

    @Override
    public void delete(Long id) {
        IBooksDao books = new BooksDAO();
        books.delete(id);
    }

    @Override
    public void update(Long id, Books u) {
        IBooksDao books = new BooksDAO();
        books.update(id, u);
    }

    @Override
    public void create(Books u) {
        IBooksDao books = new BooksDAO();
        books.saveEntity(u);
    }

    @Override
    public List<Books> getAllBooks() {
        IBooksDao books = new BooksDAO();
        return books.getAll();
    }
}
