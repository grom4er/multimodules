package com.example.databaseproject.repository;

import com.example.databaseproject.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository  extends JpaRepository<Book, Long>, BaseBookRepository {
    @Query("SELECT b FROM Book b "
            + "LEFT JOIN FETCH Record r ON r.book.id = b.id "
            + "LEFT JOIN FETCH User u on u.id = r.user.id "
            + "WHERE u.id = ?1")
    List<Book> getAllByUserId(Long userId);
}
