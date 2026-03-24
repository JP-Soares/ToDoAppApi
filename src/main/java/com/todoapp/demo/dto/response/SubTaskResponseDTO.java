package com.todoapp.demo.dto.response;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record SubTaskResponseDTO (
        UUID id,
        String name,
        String color,
        LocalDate start_date,
        LocalDate finish_date,
        LocalTime start_time,
        LocalTime finish_time
) {
}
