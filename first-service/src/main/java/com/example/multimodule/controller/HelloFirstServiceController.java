package com.example.multimodule.controller;

import com.example.multimodule.client.FeignProxy;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloFirstServiceController {
    @Setter
    private FeignProxy proxy;

    @GetMapping("/")
    public String sayHi() {
        return "Hi. I am first controller. " + proxy.sayHi();
    }

    @GetMapping("/ex")
    public String exception() {
        return proxy.exception("error"); // Если параметр будет null или error - второй сервис выдаст ошибку.
    }
}
