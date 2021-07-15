package com.javamysql.backend.repository;

import com.javamysql.backend.model.Movie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<Movie, Integer> {

    // Movie findByTitle(String title);

}