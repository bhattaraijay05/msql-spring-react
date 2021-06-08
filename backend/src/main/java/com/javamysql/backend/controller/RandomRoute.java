package com.javamysql.backend.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RandomRoute {
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "Jay") String name) {
        return String.format("Hello, My name is %s", name);
    }

    @PostMapping("/")
    public String postBody(@RequestBody String fullName) {
        return fullName;
    }

}
