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

    // get the movie with specific studio

    @Query(value = "select * from movie where studio_id = (select s.studio_id from studio s where s.studio_name = :studio)", nativeQuery = true)
    List<Movie> findByMovieStudio(@Param("studio") String studio);

    // get movie after 2015
    @Query(value = "SELECT * FROM MOVIE WHERE YEAR(movie.release_date) > :date", nativeQuery = true)
    List<Movie> findByMovieDate(@Param("date") String date);

    // get movie with specific genre
    @Query(value = "select * from movie where studio_id = (select s.studio_id from studio s where  genre_id = (select g.genre_id from genre g where genre_name = :genre)  );", nativeQuery = true)
    List<Movie> findByMovieGenre(@Param("genre") String genre);

}