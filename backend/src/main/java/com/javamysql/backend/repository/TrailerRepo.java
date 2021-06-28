
package com.javamysql.backend.repository;

import com.javamysql.backend.model.Trailer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TrailerRepo extends JpaRepository<Trailer, Integer> {
    // List<User> findByPublished(boolean published);

    // List<User> findByTitleContaining(String title);
}