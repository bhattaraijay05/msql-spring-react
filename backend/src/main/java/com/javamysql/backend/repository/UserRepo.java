package com.javamysql.backend.repository;

import java.util.List;

import com.javamysql.backend.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Integer> {
    // SELECT THE USER WITH THE PLAN_ID 1

    // Movie findByTitle(String title);
    // @Query(value = "SELECT * FROM USERS WHERE PLAN_ID = 1;", nativeQuery = true)
    // User findByPlanId(Integer planId);

    @Query(value = "SELECT * FROM USERS WHERE PLAN_ID = :planId", nativeQuery = true)
    List<User> findByPlanId(Integer planId);

}