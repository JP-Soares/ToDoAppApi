package com.todoapp.demo.service;

import com.todoapp.demo.model.Status;
import com.todoapp.demo.model.User;
import com.todoapp.demo.repository.StatusRepository;
import com.todoapp.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StatusService {
    private final StatusRepository repository;
    private final UserRepository userRepository;

    public Status save (Status status, UUID userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found!"));

        status.setUser(user);
        return repository.save(status);
    }
}
