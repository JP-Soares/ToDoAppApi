package com.todoapp.demo.validator;

import com.todoapp.demo.exceptions.NotFound;
import com.todoapp.demo.model.Task;
import com.todoapp.demo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class TaskValidator {
    private final TaskRepository repository;
    public void exists(UUID id){
        if(!repository.existsById(id)){
            throw new NotFound("Task not found!");
        }
    }
}
