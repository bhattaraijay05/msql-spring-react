package com.javamysql.backend.repository;

import com.javamysql.backend.model.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {
    // List<User> findByPublished(boolean published);

    // List<User> findByTitleContaining(String title);
}