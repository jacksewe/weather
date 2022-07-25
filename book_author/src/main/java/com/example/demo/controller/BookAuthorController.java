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

import com.example.demo.model.BookAuthor;
import com.example.demo.service.BookAuthorService;

@RestController
@RequestMapping("/api/bookAuthors")
public class BookAuthorController {
    private final BookAuthorService bookAuthorService;

    @Autowired
    public BookAuthorController(BookAuthorService bookAuthorService) {
        super();
        this.bookAuthorService = bookAuthorService;
    }

    @PostMapping
    public ResponseEntity<BookAuthor> saveBookAuthors(
            @RequestBody BookAuthor bookAuthor) {
        return new ResponseEntity<BookAuthor>(
                this.bookAuthorService.saveBookAuthor(bookAuthor),
                HttpStatus.CREATED);
    }

    @GetMapping
    public List<BookAuthor> getAllBookAuthors() {
        return this.bookAuthorService.getAllBookAuthors();
    }

    //http://localhost:8080/api/bookAuthors/1, get employee with id 1
    @GetMapping("{id}")
    public ResponseEntity<BookAuthor> getBookAuthorById(
            @PathVariable("id") long id) {
        return new ResponseEntity<BookAuthor>(
                this.bookAuthorService.getBookAuthorById(id), HttpStatus.OK);
    }

    //not tested
    @PutMapping("{id}")
    public ResponseEntity<BookAuthor> updateBookAuthor(
            @PathVariable("id") long id, @RequestBody BookAuthor bookAuthor) {
        return new ResponseEntity<BookAuthor>(
                this.bookAuthorService.updateBookAuthor(bookAuthor, id),
                HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") long id) {
        //delete bookAuthor from DB
        this.bookAuthorService.deleteBookAuthor(id);
        return new ResponseEntity<String>("BookAuthor deleted", HttpStatus.OK);
    }

}
