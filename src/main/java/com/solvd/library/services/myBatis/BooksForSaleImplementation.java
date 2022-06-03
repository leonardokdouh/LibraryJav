package com.solvd.library.services.myBatis;

import com.solvd.library.bin.BooksForSale;
import com.solvd.library.dao.IBooksForSale;
import com.solvd.library.services.BooksForSaleService;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class BooksForSaleImplementation extends AbsSqlSession implements BooksForSaleService {

    private static final Logger LOG = LogManager.getLogger(BooksForSaleImplementation.class);

    @Override
    public List<BooksForSale> getAllBooks() {
        try (SqlSession session = sqlSession()) {
            IBooksForSale booksForSale = session.getMapper(IBooksForSale.class);
            List<BooksForSale> booksLists = booksForSale.getAll();
            return booksLists;
        }
    }
}
