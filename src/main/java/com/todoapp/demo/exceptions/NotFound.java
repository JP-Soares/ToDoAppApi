package com.todoapp.demo.exceptions;


public class NotFound extends RuntimeException {
    public NotFound(String message) {
        super(message);
    }
}
