package com.test.blogapp.controller;

import com.test.blogapp.data.entity.Author;
import com.test.blogapp.data.request.UpdateAuthorRequest;
import com.test.blogapp.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        var saved = authorService.createAuthor(author);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/id/{authorId}")
    public ResponseEntity<Author> getAuthor(@PathVariable Long authorId) {
        return ResponseEntity.ok(authorService.getAuthorById(authorId));
    }

    @GetMapping("/{username}")
    public ResponseEntity<Author> getAuthorByUsername(@PathVariable String username) {
        return ResponseEntity.ok(authorService.getAuthorByUsername(username));
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAuthors(@RequestParam(required = false) String name) {
        if (name != null) {
            return ResponseEntity.ok(authorService.getAuthorsByName(name));
        }
        return ResponseEntity.ok(authorService.getAuthors());
    }

    @PatchMapping("/{authorId}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long authorId,
                                               @RequestBody UpdateAuthorRequest updAuthor) {

        return ResponseEntity.ok(authorService.updateAuthor(updAuthor, authorId));
    }

    @DeleteMapping("/{authorId}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Long authorId) {
        authorService.deleteAuthor(authorId);
        return ResponseEntity.ok("Deleted author with id " + authorId);
    }

}
