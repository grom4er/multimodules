package com.example.multimodule.controller;

import com.example.multimodule.ApplicationSecond;
import com.example.multimodule.exception.AuthException;
import com.example.multimodule.exception.ControllerException;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationSecond.class)
@WebAppConfiguration
public class HelloSecondServiceControllerTest {
    @Autowired
    private WebApplicationContext context;
    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void withRightHeaderEndpointHelloTest() {
        RestAssuredMockMvc
                .given().mockMvc(mvc)
                .header("auth", "let_me_in")
                .when().get("/hello")
                .then().statusCode(200);

    }

    @Test
    public void withWrongHeaderEndpointHelloTest() {
        RestAssuredMockMvc
                .given().mockMvc(mvc)
                .header("aUth", "lEt_mE_In")
                .when().get("/hello")
                .then().statusCode(401);
    }

    @Test
    public void withoutHeaderEndpointHelloTest() {
        RestAssuredMockMvc
                .given().mockMvc(mvc)
                .when().get("/hello")
                .then().statusCode(401);
    }

    @Test
    public void withoutParamEndpointException() {
         RestAssuredMockMvc
                        .given().mockMvc(mvc)
                        .when().get("/exception");

    }
}

/*

@GetMapping("/exception")
    public String exception(@RequestParam String msg) throws ControllerException {
        if (msg == null || msg.equals("error")) {
            throw new ControllerException("Problem with controller");
        }
        return "I'm second-service" + " msg from service: " + msg;
    }
 */