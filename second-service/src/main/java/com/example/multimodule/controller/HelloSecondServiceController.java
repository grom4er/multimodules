package com.example.multimodule.controller;

import com.example.multimodule.exception.ControllerException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloSecondServiceController {
    @GetMapping("/hello")
    public String sayHi() {
        return "Hello, i am second controller. ";
    }

    @GetMapping("/exception")
    public void exception() throws ControllerException {
        throw new ControllerException("Problem with controller");
    }
}
