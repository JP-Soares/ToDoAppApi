package com.todoapp.demo.model;

import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "sub_tasks")
public class SubTask {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "color", nullable = true)
    private String color;

    @Column(name = "start_date", nullable = true)
    private LocalDate startDate;

    @Column(name = "finish_date", nullable = true)
    private LocalDate finishDate;

    @Column(name = "start_time", nullable = true)
    private Time startTime;

    @Column(name = "finish_time", nullable = true)
    private Time finishTime;

    @ManyToOne
    @JoinColumn(name = "id_task", nullable = false)
    private Task task;
}
