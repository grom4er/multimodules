package com.example.multimodule.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "hello", url = "${feign.client.url}", configuration = ErrorDecoderConfiguration.class)
public interface FeignProxy {
    @GetMapping(value = "/hello")
    String sayHi();

    @GetMapping(value = "/exception")
    String exception();
}
