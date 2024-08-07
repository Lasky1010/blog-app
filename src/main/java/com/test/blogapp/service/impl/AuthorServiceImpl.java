package com.test.blogapp.service.impl;

import com.test.blogapp.data.entity.Author;
import com.test.blogapp.data.repository.AuthorRepository;
import com.test.blogapp.data.request.UpdateAuthorRequest;
import com.test.blogapp.exception.AuthorNotFoundException;
import com.test.blogapp.service.AuthorService;
import com.test.blogapp.util.AuthorUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElseThrow(AuthorNotFoundException::new);
    }

    @Override
    public Author getAuthorByUsername(String username) {
        return authorRepository.findByUsername(username).orElseThrow(AuthorNotFoundException::new);
    }

    @Override
    public List<Author> getAuthorsByName(String name) {
        var authors = authorRepository.findByNameContainingIgnoreCase(name);
        if (authors.isEmpty()) {
            throw new AuthorNotFoundException();
        }
        return authors;
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAuthors() {
        var authors = authorRepository.findAll();
        if (authors.isEmpty()) {
            throw new AuthorNotFoundException();
        }
        return authors;
    }

    @Override
    public Author updateAuthor(UpdateAuthorRequest updAuthor, Long id) {
        var author = authorRepository.findById(id).orElseThrow(AuthorNotFoundException::new);
        return authorRepository.save(AuthorUtil.updateAuthor(updAuthor, author));
    }

    @Override
    public void deleteAuthor(Long authorId) {
        var author = authorRepository.findById(authorId).orElseThrow(AuthorNotFoundException::new);
        authorRepository.delete(author);
    }
}
