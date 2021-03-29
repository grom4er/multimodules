package com.example.databaseproject.dto.mapper.impl;

import com.example.databaseproject.dto.mapper.ResponseMapper;
import com.example.databaseproject.dto.response.BookResponse;
import com.example.databaseproject.model.Book;
import org.springframework.stereotype.Component;

@Component
public class ResponseBookMapper implements ResponseMapper<BookResponse, Book> {
    @Override
    public BookResponse mapToDto(Book entity) {
        BookResponse bookResponse = new BookResponse();
        bookResponse.setPages(entity.getPages());
        bookResponse.setTitle(entity.getTitle());
        return bookResponse;
    }
}
