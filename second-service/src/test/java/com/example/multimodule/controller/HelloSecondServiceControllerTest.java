package com.example.multimodule.controller;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
