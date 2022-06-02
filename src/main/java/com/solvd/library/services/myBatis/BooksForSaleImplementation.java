package com.solvd.library.services.myBatis;

import com.solvd.library.bin.BooksForSale;
import com.solvd.library.dao.IBooksForSale;
import com.solvd.library.services.BooksForSaleService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BooksForSaleImplementation  extends AbsSqlSession implements BooksForSaleService {
    @Override
    public List<BooksForSale> getAllBooks() {
        try (SqlSession session = sqlSession()) {
            IBooksForSale booksForSale = session.getMapper(IBooksForSale.class);
            List<BooksForSale> booksLists = booksForSale.getAll();
            return booksLists;
        }
    }
}
