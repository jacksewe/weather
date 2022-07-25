package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.BookAuthor;
import com.example.demo.repository.BookAuthorRepository;
import com.example.demo.service.BookAuthorService;

@Service
public class BookAuthorServiceImpl implements BookAuthorService {

    private BookAuthorRepository BookAuthorRepository;

    public BookAuthorServiceImpl(BookAuthorRepository BookAuthorRepository) {
        super();
        this.BookAuthorRepository = BookAuthorRepository;
    }

    @Override
    public BookAuthor saveBookAuthor(BookAuthor BookAuthor) {
        return this.BookAuthorRepository.save(BookAuthor);
    }

    @Override
    public List<BookAuthor> getAllBookAuthors() {
        return this.BookAuthorRepository.findAll();
    }

    //need testing
    @Override
    public BookAuthor getBookAuthorById(long id) {
//        Optional<BookAuthor> BookAuthor = this.BookAuthorRepository.findById(id);
//        if (BookAuthor.isPresent()) {
//            return BookAuthor.get();
//        } else {
//            throw new ResourceNotFoundException("BookAuthor", "Id", id);
//        }

        return this.BookAuthorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("BookAuthor", "Id", id));
    }

    @Override
    public BookAuthor updateBookAuthor(BookAuthor BookAuthor, long id) {
        // check if BookAuthor with given id exists
        BookAuthor existingBookAuthor = this.BookAuthorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BookAuthor",
                        "Id", id));
        existingBookAuthor.setAuthor(BookAuthor.getAuthor());
        existingBookAuthor.setBook(BookAuthor.getBook());

        //save existing BookAuthor
        this.BookAuthorRepository.save(existingBookAuthor);
        return existingBookAuthor;
    }

    @Override
    public void deleteBookAuthor(long id) {
        //check if BookAuthor exists
        this.BookAuthorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("BookAuthor", "Id", id));
        this.BookAuthorRepository.deleteById(id);

    }

}
