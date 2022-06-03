package com.solvd.library.services.myBatis;

import com.solvd.library.bin.BooksForLend;
import com.solvd.library.dao.IBooksForLend;
import com.solvd.library.services.BooksForLendsService;
import com.solvd.library.services.jdbcImplem.BooksForSaleServiceImp;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class BooksForLendImplementation  extends AbsSqlSession implements BooksForLendsService {

    private static final Logger LOG = LogManager.getLogger(BooksForLendImplementation.class);

    @Override
    public List<BooksForLend> getAllBooks() {
        try (SqlSession session = sqlSession()) {
            IBooksForLend booksForLend = session.getMapper(IBooksForLend.class);
            List<BooksForLend> book = booksForLend.getAll();
            return book;
        }
    }
}
