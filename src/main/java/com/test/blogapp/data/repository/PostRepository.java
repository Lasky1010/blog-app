package com.test.blogapp.data.repository;

import com.test.blogapp.data.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByTitleContainingIgnoreCase(String title);

    List<Post> findByAuthorId(Long id);

}
