
package com.javamysql.backend.repository;

import com.javamysql.backend.model.Studio;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudioRepo extends JpaRepository<Studio, Integer> {
    // List<User> findByPublished(boolean published);

    // List<User> findByTitleContaining(String title);
}