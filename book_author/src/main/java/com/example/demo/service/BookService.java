package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Book;

public interface BookService {
    Book saveBook(Book book);

    List<Book> getAllBooks();

    Book getBookById(long id);

    Book updateBook(Book book, long id);

    void deleteBook(long id);
}
