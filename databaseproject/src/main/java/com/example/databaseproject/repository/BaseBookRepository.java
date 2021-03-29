package com.example.databaseproject.repository;

import com.example.databaseproject.model.Book;

import java.util.List;

public interface BaseBookRepository {
    List<Book> getTopThreeBooksByUserYoungerThenTen();
}
