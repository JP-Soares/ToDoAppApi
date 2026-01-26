package com.todoapp.demo.service;

import com.todoapp.demo.model.Status;
import com.todoapp.demo.model.Task;
import com.todoapp.demo.model.User;
import com.todoapp.demo.repository.TaskRepository;
import com.todoapp.demo.validator.TaskValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository repository;
    private final StatusService statusService;
    private final UserService userService;
    private final TaskValidator validator;

    public Task save(Task task, UUID idStatus, UUID idUser){
        Status status = statusService.getById(idStatus).orElseThrow(() -> new EntityNotFoundException("Status not found"));
        User user = userService.getById(idUser).orElseThrow(()->new EntityNotFoundException("User not found"));
        task.setStatus(status);
        task.setUser(user);
        return repository.save(task);
    }

    public Optional<Task> getById(UUID id){
        validator.exists(id);
        return repository.findById(id);
    }
}
