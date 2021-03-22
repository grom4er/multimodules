package com.example.multimodule.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSecondServiceController {
    @GetMapping("/hello")
    public String sayHi() {
        return "Hello, i am second controller. ";
    }
}
