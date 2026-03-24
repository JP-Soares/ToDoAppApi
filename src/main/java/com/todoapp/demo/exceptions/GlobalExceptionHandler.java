package com.todoapp.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class GlobalExceptionHandler{
  @ExceptionHandler(NotFound.class)
  public ResponseEntity<String> handleNotFound(NotFound e) {
    return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(e.getMessage());
  }

  @ExceptionHandler(HttpClientErrorException.BadRequest.class)
  public ResponseEntity<String> handleBadRequest(HttpClientErrorException.BadRequest e){
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
  }
}
