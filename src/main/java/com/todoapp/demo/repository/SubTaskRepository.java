package com.todoapp.demo.repository;

import com.todoapp.demo.model.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SubTaskRepository extends JpaRepository<SubTask, UUID> {

}
