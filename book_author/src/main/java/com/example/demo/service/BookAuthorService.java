package com.example.demo.service;

import java.util.List;

import com.example.demo.model.BookAuthor;

public interface BookAuthorService {
    BookAuthor saveBookAuthor(BookAuthor BookAuthor);

    List<BookAuthor> getAllBookAuthors();

    BookAuthor getBookAuthorById(long id);

    BookAuthor updateBookAuthor(BookAuthor BookAuthor, long id);

    void deleteBookAuthor(long id);
}
