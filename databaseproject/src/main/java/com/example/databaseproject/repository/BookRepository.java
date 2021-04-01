package com.example.databaseproject.repository;

import com.example.databaseproject.model.Book;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.Repository;

import javax.persistence.QueryHint;
import java.util.List;

public interface BookRepository extends Repository<Book, Long>, BaseBookRepository {
    List<Book> findByUsers_id(long userId);
}


