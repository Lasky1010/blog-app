package com.test.blogapp.handler;

import com.test.blogapp.data.response.ExceptionResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleEntityNotFound(EntityNotFoundException e) {
        return buildResponseEntity(e.getMessage());
    }

    private ResponseEntity<ExceptionResponse> buildResponseEntity(String message) {
        var response = ExceptionResponse.builder().status(HttpStatus.NOT_FOUND).message(message).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

}


