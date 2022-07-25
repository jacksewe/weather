package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository AuthorRepository;

    public AuthorServiceImpl(AuthorRepository AuthorRepository) {
        super();
        this.AuthorRepository = AuthorRepository;
    }

    @Override
    public Author saveAuthor(Author Author) {
        return this.AuthorRepository.save(Author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return this.AuthorRepository.findAll();
    }

    //need testing
    @Override
    public Author getAuthorById(long id) {
//        Optional<Author> Author = this.AuthorRepository.findById(id);
//        if (Author.isPresent()) {
//            return Author.get();
//        } else {
//            throw new ResourceNotFoundException("Author", "Id", id);
//        }

        return this.AuthorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Author", "Id", id));
    }

    @Override
    public Author updateAuthor(Author Author, long id) {
        // check if Author with given id exists
        Author existingAuthor = this.AuthorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Author", "Id", id));
        existingAuthor.setName(Author.getName());
        //save existing Author
        this.AuthorRepository.save(existingAuthor);
        return existingAuthor;
    }

    @Override
    public void deleteAuthor(long id) {
        //check if Author exists
        this.AuthorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Author", "Id", id));
        this.AuthorRepository.deleteById(id);

    }
}
