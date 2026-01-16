package com.todoapp.demo.service;

import com.todoapp.demo.model.Status;
import com.todoapp.demo.repository.StatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatusService {
    private final StatusRepository repository;

    public Status save (Status status){
        return repository.save(status);
    }
}
