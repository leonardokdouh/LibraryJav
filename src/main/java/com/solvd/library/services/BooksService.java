package com.solvd.library.services;


import com.solvd.library.bin.Books;

import java.util.List;

public interface BooksService {

    Books getBooks(Long id);

    void delete(Long id);

    void update(Long id, Books u);

    void create(Books u);

    List<Books> getallBooks();

}
