package com.example.databaseproject.repository;

import com.example.databaseproject.model.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BaseBookRepositoryImpl implements BaseBookRepository {
    private static final int BOOK_COUNT = 3;
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Book> getTopThreeBooksByUserYoungerThenTen() {
        return manager.createQuery("SELECT b FROM Book b "
                        + "LEFT JOIN  Record r ON r.book.id = b.id "
                        + "LEFT JOIN  User u on u.id = r.user.id "
                        + "WHERE u.age <= 10 "
                        + "GROUP BY b.id "
                        + "ORDER BY COUNT(b.id) ASC ",
                Book.class).setMaxResults(BOOK_COUNT).getResultList();
    }
}
