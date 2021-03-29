package com.example.databaseproject.dto.mapper;

public interface ResponseMapper<T, I> {
    T mapToDto(I entity);
}
