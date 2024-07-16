package com.test.blogapp.service;

import com.test.blogapp.data.entity.Author;

import java.util.List;

public interface AuthorService {

    Author getAuthorById(Long id);

    Author getAuthorByUsername(String username);

    List<Author> getAuthorsByName(String name);

    Author createAuthor(Author author);

    List<Author> getAuthors();
}
