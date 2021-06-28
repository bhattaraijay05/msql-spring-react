package com.javamysql.backend.repository;

import java.util.List;

import com.javamysql.backend.model.Movie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<Movie, Integer> {
    // List<Movie> findByPublished(Integer movieId);

    // List<User> findByTitleContaining(String title);
}