package com.example.multimodule.controller;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@RunWith(SpringJUnit4ClassRunner.class)
class HelloSecondServiceControllerTest {
    @BeforeAll
    public static void configurate() {
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test
    public void testOkHttp() {
        given().when().get("/hello").then().statusCode(200);
    }

    @Test
    public void test() {
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/hello");
        ResponseBody body = response.getBody();
        assertEquals("Hello, i am second controller. ", body.asString());
    }
}


/*
import com.example.databaseproject.controller.BookController;
import io.restassured.RestAssured;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
public class DatabaseProjectControllerTest {
    @Autowired
    private BookController controller;
    @LocalServerPort
    private int port;

    @BeforeAll
    public static void configurate() {
        RestAssured.baseURI = "http://localhost";
    }

    @Test
    public void testOkHttpFirstEndpoint() {
        given().port(port)
                .when()
                .get("/books/popular")
                .then()
                .statusCode(200);
    }

    @Test
    public void contextLoad() {
        assertThat(controller).isNotNull();
    }
}
 */