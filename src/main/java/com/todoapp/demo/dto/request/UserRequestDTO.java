package com.todoapp.demo.dto.request;

public record UserRequestDTO(
        String login,
        String password,
        String name
){}
