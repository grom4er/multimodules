package com.example.databaseproject.service.impl;

import com.example.databaseproject.model.Book;
import com.example.databaseproject.repository.BookRepository;
import com.example.databaseproject.service.BookService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Setter
    @Autowired
    private BookRepository repository;
    @Cacheable("user")
    @Override
    public List<Book> findByUserId(Long userId) {
        return repository.findByUsers_id(userId);
    }
    @Cacheable("user")
    @Override
    public List<Book> getTopThreeBooksByUserYoungerThenTen() {
        return repository.getTopThreeBooksByUserYoungerThenTen();
    }
}
