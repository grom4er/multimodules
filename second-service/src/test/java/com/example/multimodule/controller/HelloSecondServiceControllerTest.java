package com.example.multimodule.controller;

import com.example.multimodule.ApplicationSecond;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
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
    public void withParamAndAuthEndpointExceptionTest() {
        String msg = "information";
        String expect = "I'm second-service msg from service: ";
        RestAssuredMockMvc
                .given().mockMvc(mvc)
                .header("auth", "let_me_in").param("message", msg)
                .when().get("/exception")
                .then()
                .statusCode(200)
                .body("msg", Matchers.equalTo(expect + msg));
    }

    @Test
    public void withParamExceptionEndpointExceptionTest() {
        RestAssuredMockMvc
                .given().mockMvc(mvc)
                .header("auth", "let_me_in").param("message", "error")
                .when().get("/exception")
                .then()
                .statusCode(417);
    }

}
