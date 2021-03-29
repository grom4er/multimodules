package com.example.databaseproject.controller;

import com.example.databaseproject.dto.mapper.impl.ResponseBookMapper;
import com.example.databaseproject.dto.response.BookResponse;
import com.example.databaseproject.service.BookService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {
    @Setter
    @Autowired
    private BookService service;

    @Setter
    @Autowired
    private ResponseBookMapper responseBookMapper;

    @GetMapping("/popular")
    public List<BookResponse> getChildrenPopulationBooks() {
        return service.getTopThreeBooksByUserOlderThenTen()
                .stream()
                .map(responseBookMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public List<BookResponse> getBooksByUserId(@RequestParam Long userId) {
        return service.findByUserId(userId)
                .stream()
                .map(responseBookMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
