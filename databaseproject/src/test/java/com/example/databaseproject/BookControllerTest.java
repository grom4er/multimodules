package com.example.databaseproject;

import com.example.databaseproject.controller.BookController;
import com.example.databaseproject.dto.mapper.impl.ResponseBookMapper;
import com.example.databaseproject.model.Book;
import com.example.databaseproject.service.BookService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebMvcTest(value = {BookController.class})
public class BookControllerTest {
    private final List<Book> BOOK_LIST_ONE = new ArrayList<>();
    @MockBean
    private BookService service;

    @Autowired
    private MockMvc mockMvc;

    @TestConfiguration
    public static class AdditionalConfig {
        @Bean
        public ResponseBookMapper productValidator() {
            return new ResponseBookMapper();
        }
    }

    @BeforeEach
    void init() {
        BOOK_LIST_ONE.clear();
        BOOK_LIST_ONE.add(new Book(1L, "Harry Potter", 449));
        BOOK_LIST_ONE.add(new Book(2L, "Bible", 60));
        BOOK_LIST_ONE.add(new Book(3L, "The Great Gatsby", 440));
    }

    @BeforeEach
    public void setUp() {
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    void TakeTopThreeBooksTest() {
        Mockito.when(service.getTopThreeBooksByUserYoungerThenTen())
                .thenReturn(BOOK_LIST_ONE);

        RestAssuredMockMvc
                .given()
                .when()
                .get("/books/popular")
                .then()
                .body("[0].title", Matchers.equalTo("Harry Potter"))
                .body("[0].pages", Matchers.equalTo(449))
                .body("[1].title", Matchers.equalTo("Bible"))
                .body("[1].pages", Matchers.equalTo(60))
                .body("[2].title", Matchers.equalTo("The Great Gatsby"))
                .body("[2].pages", Matchers.equalTo(440))
                .statusCode(200);
    }

    @Test
    public void getBooksByUserIdTest() {
        Mockito.when(service.findByUserId(2L))
                .thenReturn(BOOK_LIST_ONE);
        RestAssuredMockMvc
                .given()
                .queryParam("userId", "2")
                .when()
                .post("/books")
                .then()
                .body("[0].title", Matchers.equalTo("Harry Potter"))
                .body("[0].pages", Matchers.equalTo(449))
                .body("[1].title", Matchers.equalTo("Bible"))
                .body("[1].pages", Matchers.equalTo(60))
                .body("[2].title", Matchers.equalTo("The Great Gatsby"))
                .body("[2].pages", Matchers.equalTo(440))
                .statusCode(200);
    }

    @Test
    void TakeTopThreeBooksWithoutDataTest() {
        Mockito.when(service.getTopThreeBooksByUserYoungerThenTen())
                .thenReturn(Collections.emptyList());

        RestAssuredMockMvc
                .given()
                .when()
                .get("/books/popular")
                .then()
                .statusCode(200);
    }
    @Test
    public void getBooksByUserIdWithoutDataTest() {
        Mockito.when(service.findByUserId(2L))
                .thenReturn(Collections.emptyList());
        RestAssuredMockMvc
                .given()
                .queryParam("userId", "2")
                .when()
                .post("/books")
                .then()
                .statusCode(200);
    }
}
