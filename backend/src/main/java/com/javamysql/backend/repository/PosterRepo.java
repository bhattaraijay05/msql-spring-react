
package com.javamysql.backend.repository;

import com.javamysql.backend.model.Poster;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PosterRepo extends JpaRepository<Poster, Integer> {
    // List<User> findByPublished(boolean published);

    // List<User> findByTitleContaining(String title);
}