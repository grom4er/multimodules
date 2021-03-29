package com.example.databaseproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.databaseproject")
public class DataBaseProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataBaseProjectApplication.class, args);
    }
}
