package com.javamysql.backend.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public List<Movie> findbymovie(@PathVariable("movie") String movie) {
        return movieRepository.findByMovie(movie);
    }

    @GetMapping("/movie/date/{date}")
    public List<Movie> findbymovieAfterDate(@PathVariable("date") String date) {
        return movieRepository.findByMovieDate(date);
    }

    @GetMapping("/movie/genre/{genre}")
    public List<Movie> findByMovieGenre(@PathVariable("genre") String genre) {
        return movieRepository.findByMovieGenre(genre);
    }

    @GetMapping("/movie/studio/{studio}")
    public List<Movie> findbymoviestudio(@PathVariable("studio") String studio) {
        return movieRepository.findByMovieStudio(studio);
    }

    @PostMapping(path = "/add", consumes = { "application/json" }, produces = "application/json") // Map ONLY POST
    public ResponseEntity<Movie> addNewMovie(@RequestBody Movie movie) {
        Movie _movie = movieRepository.save(movie);
        return new ResponseEntity<>(_movie, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") int id) {
        try {
            movieRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Movie> updateTutorial(@PathVariable("id") int id, @RequestBody Movie movie) {
        Optional<Movie> movieData = movieRepository.findById(id);

        if (movieData.isPresent()) {
            Movie _movie = movieData.get();
            _movie.setName(movie.getName());
            _movie.setDescription(movie.getDescription());
            return new ResponseEntity<>(movieRepository.save(_movie), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
