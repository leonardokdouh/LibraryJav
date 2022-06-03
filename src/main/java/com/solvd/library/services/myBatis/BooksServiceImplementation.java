package com.solvd.library.services.myBatis;

import com.solvd.library.bin.Books;
import com.solvd.library.dao.IBooksDao;
import com.solvd.library.services.BooksService;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class BooksServiceImplementation  extends AbsSqlSession implements BooksService {

    private static final Logger LOG = LogManager.getLogger(BooksServiceImplementation.class);


    @Override
    public Books getBooks(Long id) {
        try (SqlSession session = sqlSession()) {
            IBooksDao books = session.getMapper(IBooksDao.class);
            Books newBook = books.getEntity(id);
        return newBook;
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session = sqlSession()) {
            IBooksDao books = session.getMapper(IBooksDao.class);
            books.delete(id);
            session.commit();


        }
    }

    @Override
    public void update(Long id, Books u) {
        try (SqlSession session = sqlSession()) {
            IBooksDao books = session.getMapper(IBooksDao.class);
            books.update(id, u);
            session.commit();
    }
    }

    @Override
    public void create(Books u) {
        try (SqlSession session = sqlSession()) {
            IBooksDao books = session.getMapper(IBooksDao.class);
            books.saveEntity(u);
            session.commit();

        }
    }

    @Override
    public List<Books> getallBooks() {
        try (SqlSession session = sqlSession()) {
            IBooksDao books = session.getMapper(IBooksDao.class);
            List<Books> listBooks = books.getAll();

            return listBooks;
        }
    }
}
