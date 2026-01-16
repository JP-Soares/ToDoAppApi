package com.todoapp.demo.dto;

import java.util.UUID;

public record StatusDTO(
        String name,
        String color,
        UUID user
        ) {
}
