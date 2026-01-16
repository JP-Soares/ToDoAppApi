package com.todoapp.demo.service;

import com.todoapp.demo.model.User;
import com.todoapp.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public User save(User user){
        System.out.println("USER: "+user);
        return repository.save(user);
    }
}
