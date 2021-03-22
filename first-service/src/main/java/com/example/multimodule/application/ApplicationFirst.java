package com.example.multimodule.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.example.multimodule")
@SpringBootApplication(scanBasePackages = "com.example.multimodule")
public class ApplicationFirst {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationFirst.class, args);
    }
}
