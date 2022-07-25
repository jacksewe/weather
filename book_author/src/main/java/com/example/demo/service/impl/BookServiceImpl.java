package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        super();
        this.bookRepository = bookRepository;
    }

    @Override
    public Book saveBook(Book book) {
        return this.bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    //need testing
    @Override
    public Book getBookById(long id) {
//        Optional<Book> book = this.bookRepository.findById(id);
//        if (book.isPresent()) {
//            return book.get();
//        } else {
//            throw new ResourceNotFoundException("Book", "Id", id);
//        }

        return this.bookRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Book", "Id", id));
    }

    @Override
    public Book updateBook(Book book, long id) {
        // check if book with given id exists
        Book existingBook = this.bookRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Book", "Id", id));
        existingBook.setName(book.getName());
        //save existing book
        this.bookRepository.save(existingBook);
        return existingBook;
    }

    @Override
    public void deleteBook(long id) {
        //check if book exists
        this.bookRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Book", "Id", id));
        this.bookRepository.deleteById(id);

    }
}
