package com.todoapp.demo.dto.response;


import java.time.LocalDate;
import java.time.LocalTime;

public record TaskResponseDTO(
        String name,
        String color,
        LocalDate startDate,
        LocalDate finishDate,
        LocalTime startTime,
        LocalTime finishTime
) {
}
