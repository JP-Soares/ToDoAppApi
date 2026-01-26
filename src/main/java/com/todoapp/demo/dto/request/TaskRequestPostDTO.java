package com.todoapp.demo.dto.request;

import jakarta.annotation.Nullable;

import java.sql.Time;
import java.time.LocalDate;
import java.util.UUID;

public record TaskRequestPostDTO (
        String name,
        String color,
        @Nullable
        LocalDate start_date,
        @Nullable
        LocalDate finish_date,
        @Nullable
        Time stat_time,
        @Nullable
        Time finish_time,
        UUID user,
        UUID status
){
}
