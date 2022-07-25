package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        super();
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        return new ResponseEntity<Book>(this.bookService.saveBook(book),
                HttpStatus.CREATED);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return this.bookService.getAllBooks();
    }

    //http://localhost:8080/api/books/1, get employee with id 1
    @GetMapping("{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") long id) {
        return new ResponseEntity<Book>(this.bookService.getBookById(id),
                HttpStatus.OK);
    }

    //not tested
    @PutMapping("{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") long id,
            @RequestBody Book book) {
        return new ResponseEntity<Book>(this.bookService.updateBook(book, id),
                HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") long id) {
        //delete book from DB
        this.bookService.deleteBook(id);
        return new ResponseEntity<String>("Book deleted", HttpStatus.OK);
    }

}
