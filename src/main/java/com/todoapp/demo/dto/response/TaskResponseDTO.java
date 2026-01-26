package com.todoapp.demo.dto.response;

import java.sql.Time;
import java.time.LocalDate;

public record TaskResponseDTO(
        String name,
        String color,
        LocalDate start_date,
        LocalDate finish_date,
        Time start_time,
        Time finish_time
) {
}
