package com.todoapp.demo.service;

import com.todoapp.demo.model.SubTask;
import com.todoapp.demo.model.Task;
import com.todoapp.demo.repository.SubTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubTaskService {
    private final SubTaskRepository repository;
    private final TaskService taskService;
    private final Task task;

    public SubTask save(SubTask subTask){
        return repository.save(subTask);
    }
}
