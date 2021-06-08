package com.javamysql.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// @SpringBootApplication
// @RestController
// @CrossOrigin(origins = "*", allowedHeaders = "*")
// public class BackendApplication {

// public static void main(String[] args) {
// SpringApplication.run(BackendApplication.class, args);
// }

// @GetMapping("/hello")
// public String hello(@RequestParam(value = "name", defaultValue = "Jay")
// String name) {
// return String.format("Hello, My name is %s", name);
// }

// @GetMapping("/")
// public String index() {
// return String.format("Your app is sucessfully running");
// }

// @PostMapping("/")
// public String postBody(@RequestBody String fullName) {
// return fullName;
// }

// }
