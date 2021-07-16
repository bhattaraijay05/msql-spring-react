package com.javamysql.backend.controller;

import java.util.List;

import com.javamysql.backend.model.Movie;
import com.javamysql.backend.model.Poster;
import com.javamysql.backend.model.Trailer;
import com.javamysql.backend.repository.MovieRepo;
import com.javamysql.backend.repository.PosterRepo;
import com.javamysql.backend.repository.TrailerRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private PosterRepo posterRepository;
    private TrailerRepo trailerRepository;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // @PostMapping(path = "/add", consumes = "application/json", produces =
    // "application/json") // Map ONLY POST Requests
    // public ResponseEntity<Movie> addNewUser(@RequestBody Movie movie) {
    // Movie _movie = movieRepository.save(movie);
    // return new ResponseEntity<>(_movie, HttpStatus.CREATED);
    // }

    @GetMapping("/movie/{movie}")
    public List<Movie> findUsers(@PathVariable("movie") String movie) {
        return movieRepository.findByMovie(movie);
    }

    @PostMapping(path = "/add", consumes = { "application/json" }, produces = "application/json") // Map ONLY POST
    public ResponseEntity<Movie> addNewMovie(@RequestBody Movie movie) {
        Movie _user = movieRepository.save(movie);
        return new ResponseEntity<>(_user, HttpStatus.CREATED);
    }

}
