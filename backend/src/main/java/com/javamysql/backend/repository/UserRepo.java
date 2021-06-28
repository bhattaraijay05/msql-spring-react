package com.javamysql.backend.repository;

import com.javamysql.backend.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

}