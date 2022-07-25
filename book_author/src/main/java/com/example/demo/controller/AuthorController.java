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

import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    private final AuthorService AuthorService;

    @Autowired
    public AuthorController(AuthorService AuthorService) {
        super();
        this.AuthorService = AuthorService;
    }

    @PostMapping
    public ResponseEntity<Author> saveAuthor(@RequestBody Author Author) {
        return new ResponseEntity<Author>(this.AuthorService.saveAuthor(Author),
                HttpStatus.CREATED);
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return this.AuthorService.getAllAuthors();
    }

    //http://localhost:8080/api/Authors/1, get employee with id 1
    @GetMapping("{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable("id") long id) {
        return new ResponseEntity<Author>(this.AuthorService.getAuthorById(id),
                HttpStatus.OK);
    }

    //not tested
    @PutMapping("{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable("id") long id,
            @RequestBody Author Author) {
        return new ResponseEntity<Author>(
                this.AuthorService.updateAuthor(Author, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable("id") long id) {
        //delete Author from DB
        this.AuthorService.deleteAuthor(id);
        return new ResponseEntity<String>("Author deleted", HttpStatus.OK);
    }

}
