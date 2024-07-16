package com.test.blogapp.exception;

import jakarta.persistence.EntityNotFoundException;

public class AuthorNotFoundException extends EntityNotFoundException {

    public static final String message = "Author not found";

    public AuthorNotFoundException() {
        super(message);
    }
}
