package com.javamysql.backend.repository;

import java.util.List;

import com.javamysql.backend.model.Movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MovieRepo extends JpaRepository<Movie, Integer> {

    // // Movie findByTitle(String title);
    // @Query(value = "SELECT * FROM USERS WHERE EMAIL_ADDRESS = ?1", nativeQuery =
    // true)
    // Movie findByGenre(String emailAddress);

    // search for any movie matching the title

    @Query(value = "SELECT * FROM MOVIE WHERE movie.title LIKE %:movie%", nativeQuery = true)
    List<Movie> findByMovie(@Param("movie") String movie);

}