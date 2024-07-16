package com.test.blogapp.exception;

import jakarta.persistence.EntityNotFoundException;

public class PostNotFoundException extends EntityNotFoundException {

    private static final String message = "Post not found";

    public PostNotFoundException() {
        super(message);
    }
}
