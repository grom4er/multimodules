package com.example.multimodule;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "hello", url = "http://localhost:8080/")
public interface FeignProxy {
    @GetMapping(value = "/hello")
    String sayHi();
}
