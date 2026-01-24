package com.todoapp.demo.service;

import com.todoapp.demo.model.Status;
import com.todoapp.demo.model.User;
import com.todoapp.demo.repository.StatusRepository;
import com.todoapp.demo.repository.UserRepository;
import com.todoapp.demo.validator.StatusValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StatusService {
    private final StatusRepository repository;
    private final UserRepository userRepository;
    private final StatusValidator validator;

    public Status save (Status status, UUID userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found!"));

        status.setUser(user);
        return repository.save(status);
    }

    public Optional<Status> getById(UUID id){
        return repository.findById(id);
    }

    public List<Status> getAll(){
        List<Status> statusList = repository.findAll();
        return statusList;
    }

    public void update(Status status){
        validator.exists(status.getId());
        repository.save(status);
    }

    public void delete(UUID id){
        try{
            validator.exists(id);//verify if the status exists
            var status = repository.getById(id);//get the status
            repository.delete(status);//delete the status
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("There are tasks associated with this status.");
        }
    }
}
