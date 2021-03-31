package com.example.databaseproject;

import com.example.databaseproject.model.Book;
import com.example.databaseproject.repository.BookRepository;
import com.example.databaseproject.service.BookService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {
    @MockBean
    private BookRepository repository;

    @Autowired
    BookService service;

    public List<Book> initTwoBook() {
        Book one = new Book(2L, " Don Quixote", 221);
        Book two = new Book(1L, "Moby Dick", 115);
        List<Book> listOfTwoBook = new ArrayList<>();
        listOfTwoBook.add(one);
        listOfTwoBook.add(two);
        return listOfTwoBook;
    }

    @Test
    public void takeTopThreeBooksButHaveOnlyTwoTest() {
        Mockito.when(repository.getTopThreeBooksByUserYoungerThenTen())
                .thenReturn(initTwoBook());
        Assertions.assertEquals(service.getTopThreeBooksByUserYoungerThenTen(), initTwoBook());
    }
    @Test
    public void takeZeroBooksTest(){
        Mockito.when(repository.getTopThreeBooksByUserYoungerThenTen())
                .thenReturn(Collections.emptyList());
        Assertions.assertEquals(service.getTopThreeBooksByUserYoungerThenTen(), Collections.emptyList());
    }

    @Test
    public void takeTwoBooksByUserIdTest(){
        Mockito.when(repository.findByUsers_id(2L))
                .thenReturn(initTwoBook());
        Assertions.assertEquals(service.findByUserId(2L), initTwoBook());
    }
    @Test
    public void takeZeoBooksByUserIdTest(){
        Mockito.when(repository.findByUsers_id(2L))
                .thenReturn(Collections.emptyList());
        Assertions.assertEquals(service.findByUserId(2L), Collections.emptyList());
    }


}
