package com.example.multimodule.controller;

import com.example.multimodule.exception.ControllerException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSecondServiceController {
    @GetMapping("/hello")
    public String sayHi() {
        return "Hello, i am second controller. ";
    }

    @GetMapping("/exception")
    public String exception(@RequestParam String msg) throws ControllerException {
        if(msg == null || msg.equals("error")){
            throw new ControllerException("Problem with controller");
        }
        return "I'm second-service" + " msg from service: " + msg;

    }
}
