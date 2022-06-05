package com.solvd.library.services.myBatis;

import com.solvd.library.bin.Books;
import com.solvd.library.dao.IBooksDao;
import com.solvd.library.services.BooksService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BooksServiceImpl extends AbsSqlSession implements BooksService {

    @Override
    public Books getBooks(Long id) {
        try (SqlSession session = sqlSession()) {
            IBooksDao books = session.getMapper(IBooksDao.class);
            return books.getEntity(id);
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
    public List<Books> getAllBooks() {
        try (SqlSession session = sqlSession()) {
            IBooksDao books = session.getMapper(IBooksDao.class);
            return books.getAll();
        }
    }
}
