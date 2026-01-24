package com.todoapp.demo.validator;

import com.todoapp.demo.repository.StatusRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class StatusValidator {

    private final StatusRepository repository;

    public void exists(UUID id){
        if(repository.getById(id) == null){
            throw new EntityNotFoundException("Status not found");
        }
    }
}
