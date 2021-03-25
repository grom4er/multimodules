package com.example.multimodule.controller;

import com.example.multimodule.client.FeignProxy;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloFirstServiceController {
    @Setter
    @Autowired
    private FeignProxy proxy;

    @GetMapping("/")
    public String sayHi(@RequestHeader(value = "auth", required = false) String header) {
        return "Hi. I am first controller. " + proxy.sayHi(header);
    }

    @GetMapping("/ex")
    public String exception(@RequestHeader(value = "auth", required = false) String header,
                            @RequestParam(value = "msg", required = false) String msg) {
        return proxy.exception(header, msg);
    }
}
