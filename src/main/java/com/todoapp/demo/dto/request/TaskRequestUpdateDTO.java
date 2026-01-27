package com.todoapp.demo.dto.request;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record TaskRequestUpdateDTO(
        @NotBlank
        String name,
        @NotBlank
        String color,
        @Nullable
        LocalDate startDate,
        @Nullable
        LocalDate finishDate,
        @Nullable
        LocalTime startTime,
        @Nullable
        LocalTime finishTime,
        @NotBlank
        UUID status
) {
}
