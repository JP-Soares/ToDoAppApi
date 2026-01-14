package com.todoapp.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="tasks")
public class Task {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false, length = 120)
    private String name;

    @Column(name = "color", nullable = true, length = 50)
    private String color;

    @Column(name = "start_date", nullable = true)
    private LocalDateTime start_date;

    @Column(name = "finish_date", nullable = true)
    private LocalDateTime finish_date;
}
