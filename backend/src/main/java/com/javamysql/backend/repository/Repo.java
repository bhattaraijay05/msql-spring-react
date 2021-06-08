package com.javamysql.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javamysql.backend.model.Name;

public interface Repo extends JpaRepository<Name, Long> {
    List<Name> findByPublished(boolean published);

    List<Name> findByTitleContaining(String title);
}
