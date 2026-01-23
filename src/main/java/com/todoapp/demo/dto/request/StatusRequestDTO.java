package com.todoapp.demo.dto.request;

import java.util.UUID;

public record StatusRequestDTO(
        String name,
        String color,
        UUID user
        ) {
}
