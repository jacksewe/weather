package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.BookAuthor;

public interface BookAuthorRepository extends JpaRepository<BookAuthor, Long> {

}
