package com.todoapp.demo.service;

import com.todoapp.demo.model.User;
import com.todoapp.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public User save(User user){
        System.out.println("USER: "+user);
        return repository.save(user);
    }

    public Optional<User> getById(UUID id){
        return repository.findById(id);
    }
}
