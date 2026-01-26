package com.todoapp.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="tasks")
@RequiredArgsConstructor
@Getter
@Setter
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
    private LocalDate startDate;

    @Column(name = "finish_date", nullable = true)
    private LocalDate finishDate;

    @Column(name = "start_time", nullable = true)
    private Time startTime;

    @Column(name = "finish_time", nullable = true)
    private Time finishTime;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_status", nullable = false)
    private Status status;
}
