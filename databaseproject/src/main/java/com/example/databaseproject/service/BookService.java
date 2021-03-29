package com.example.databaseproject.service;

import com.example.databaseproject.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findByUserId(Long userId);

    List<Book> getTopThreeBooksByUserYoungerThenTen();
}
