package com.solvd.library.services.myBatis;

import com.solvd.library.bin.BooksForLend;
import com.solvd.library.dao.IBooksForLend;
import com.solvd.library.services.BooksForLendsService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BooksForLendImplementation  extends AbsSqlSession implements BooksForLendsService {
    @Override
    public List<BooksForLend> getAllBooks() {
        try (SqlSession session = sqlSession()) {
            IBooksForLend booksForLend = session.getMapper(IBooksForLend.class);
            List<BooksForLend> book = booksForLend.getAll();
            return book;
        }
    }
}
