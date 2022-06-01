package com.solvd.library.services.jdbcImplem;

import com.solvd.library.bin.Books;
import com.solvd.library.dao.IBooksDao;
import com.solvd.library.dao.impl.BooksDAOAbs;
import com.solvd.library.services.BooksService;

import java.util.List;

public class BooksServiceImp implements BooksService {

    @Override
    public Books getBooks(Long id) {
        IBooksDao boks = new BooksDAOAbs();
        Books book = boks.getEntity(id);
        return book;
    }

    @Override
    public void delete(Long id) {
        IBooksDao boks = new BooksDAOAbs();
        boks.delete(id);
    }

    @Override
    public void update(Books u) {
        IBooksDao boks = new BooksDAOAbs();
        boks.update(u);
    }

    @Override
    public void create(Books u) {
        IBooksDao boks = new BooksDAOAbs();
        boks.saveEntity(u);
    }

    @Override
    public List<Books> getallBooks() {
        IBooksDao boks = new BooksDAOAbs();
        List<Books> booksList = boks.getAll();
        return booksList;
    }
}
