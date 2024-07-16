package com.test.blogapp.controller;

import com.test.blogapp.data.entity.Post;
import com.test.blogapp.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/{authorId}")
    public ResponseEntity<Post> createPost(@RequestBody Post post, @PathVariable Long authorId) {
        var saved = postService.createPost(post, authorId);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPost(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getPostById(postId));
    }

    @GetMapping
    public ResponseEntity<List<Post>> getPostsByTitle(@RequestParam(required = false) String title) {
        if (title != null) {
            return ResponseEntity.ok(postService.getPostsByTitle(title));
        }
        return ResponseEntity.ok(postService.getPosts());
    }

    @GetMapping("/author/{authorId}")
    public ResponseEntity<List<Post>> getPostByAuthor(@PathVariable Long authorId) {
        return ResponseEntity.ok(postService.getPostsByAuthor(authorId));
    }


}
