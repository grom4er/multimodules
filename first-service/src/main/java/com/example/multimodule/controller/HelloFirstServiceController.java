package com.example.multimodule.controller;

import com.example.multimodule.client.FeignProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan(basePackages = {"com.example.multimodule"})
public class HelloFirstServiceController {
    private final FeignProxy proxy;

    public HelloFirstServiceController(FeignProxy proxy) {
        this.proxy = proxy;
    }

    @GetMapping("/")
    public String sayHi() {
        return "Hi. I am first controller. " + proxy.sayHi();
    }
}
