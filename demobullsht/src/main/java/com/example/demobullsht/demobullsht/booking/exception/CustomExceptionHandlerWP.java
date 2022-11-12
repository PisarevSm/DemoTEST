package com.example.demobullsht.demobullsht.booking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandlerWP {
    @ExceptionHandler(value = { WorkPlaceNotFoundException.class })
    public ResponseEntity<Object> workPlaceNotFoundExceptionHandler(WorkPlaceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}