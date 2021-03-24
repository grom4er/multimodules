package com.example.multimodule.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "hello", url = "${feign.client.url}", configuration = ErrorDecoderConfiguration.class)
public interface FeignProxy {
    @GetMapping(value = "/hello")
    String sayHi();

    @RequestMapping(method = RequestMethod.GET, value = "/exception")
    String exception(@RequestHeader(value = "auth", required = false) String header,
                     @RequestParam(value = "msg", required = false) String msg);
}
