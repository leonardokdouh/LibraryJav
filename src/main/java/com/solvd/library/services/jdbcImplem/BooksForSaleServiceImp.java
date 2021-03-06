package com.solvd.library.services.jdbcImplem;

import com.solvd.library.bin.BooksForSale;
import com.solvd.library.dao.IBooksForSale;
import com.solvd.library.dao.impl.BooksForSaleDAO;
import com.solvd.library.services.BooksForSaleService;

import java.util.List;

public class BooksForSaleServiceImp implements BooksForSaleService {
    @Override
    public List<BooksForSale> getAllBooks() {
        IBooksForSale bookSale = new BooksForSaleDAO();
        return bookSale.getAll();
    }
}
