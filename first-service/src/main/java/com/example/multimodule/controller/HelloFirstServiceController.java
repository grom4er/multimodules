package com.example.multimodule.controller;

import com.example.multimodule.client.FeignProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HelloFirstServiceController {
    private final FeignProxy proxy;

    @GetMapping("/")
    public String sayHi() {
        return "Hi. I am first controller. " + proxy.sayHi();
    }

    @GetMapping("/ex")
    public void exception() {
        proxy.exception();
    }
}
