package com.todoapp.demo.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="users")
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="login", nullable = false, length = 120)
    private String login;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name="name", nullable = false, length = 255)
    private String name;
}
