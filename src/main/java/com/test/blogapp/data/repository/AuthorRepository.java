package com.test.blogapp.data.repository;

import com.test.blogapp.data.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findByUsername(String username);

    List<Author> findByNameContainingIgnoreCase(String name);
}
