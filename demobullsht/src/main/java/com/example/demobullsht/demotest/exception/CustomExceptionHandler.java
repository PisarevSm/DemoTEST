package com.example.demobullsht.demotest.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(value = { NotFoundException.class })
    public ResponseEntity<Object> NotFoundExceptionHandler(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    @ExceptionHandler(value = { AlreadyExistsException.class })
    public ResponseEntity<Object> AlreadyExistsExceptionHandler(AlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }
}