package com.example.multimodule.controller;

import com.example.multimodule.Dto.MessageDto;
import com.example.multimodule.exception.ControllerException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSecondServiceController {
    @GetMapping("/hello")
    public MessageDto sayHi() {
        return new MessageDto("Hello, i am second controller. ");
    }

    @GetMapping("/exception")
    public MessageDto exception(@RequestParam String message) throws ControllerException {
        if (message == null || message.equals("error")) {
            throw new ControllerException("Problem with controller");
        }
        return new MessageDto("I'm second-service" + " msg from service: " + message);
    }
}
