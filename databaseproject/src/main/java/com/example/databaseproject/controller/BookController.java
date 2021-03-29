package com.example.databaseproject.controller;

import com.example.databaseproject.model.Book;
import com.example.databaseproject.service.BookService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Setter
    @Autowired
    private BookService service;

    @GetMapping("/popular")
    public List<Book> getChildrenPopulationBooks() {
        return service.getTopThreeBooksByUserOlderThenTen();
    }

    @PostMapping
    public List<Book> getBooksByUserId(@RequestParam Long userId) {
        return service.findByUserId(userId);
    }
}
