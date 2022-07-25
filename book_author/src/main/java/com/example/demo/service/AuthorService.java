package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Author;

public interface AuthorService {
    Author saveAuthor(Author Author);

    List<Author> getAllAuthors();

    Author getAuthorById(long id);

    Author updateAuthor(Author Author, long id);

    void deleteAuthor(long id);
}
