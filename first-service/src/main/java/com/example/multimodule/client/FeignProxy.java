package com.example.multimodule.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "hello", url = "${feign.client.url}", configuration = ErrorDecoderConfiguration.class)
public interface FeignProxy {
    @GetMapping(value = "/hello")
    String sayHi();

    @RequestMapping(value = "/exception")
    String exception(@RequestParam("msg") String msg);
}
