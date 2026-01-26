package com.todoapp.demo.dto.request;

import jakarta.annotation.Nullable;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record TaskRequestUpdateDTO(
        String name,
        String color,
        @Nullable
        LocalDate startDate,
        @Nullable
        LocalDate finishDate,
        @Nullable
        LocalTime startTime,
        @Nullable
        LocalTime finishTime,
        UUID status
) {
}
