package com.javamysql.backend.controller;

import com.javamysql.backend.model.Movie;
import com.javamysql.backend.repository.MovieRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api")
public class MovieController {
    @Autowired
    private MovieRepo movieRepository;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json") // Map ONLY POST Requests
    public ResponseEntity<Movie> addNewUser(@RequestBody Movie movie) {
        Movie _user = movieRepository.save(movie);
        return new ResponseEntity<>(_user, HttpStatus.CREATED);
    }
}
