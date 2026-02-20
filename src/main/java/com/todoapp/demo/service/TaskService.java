package com.todoapp.demo.service;

import com.todoapp.demo.model.Status;
import com.todoapp.demo.model.Task;
import com.todoapp.demo.model.User;
import com.todoapp.demo.repository.TaskRepository;
import com.todoapp.demo.repository.specs.TaskSpecs;
import com.todoapp.demo.validator.TaskValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
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

    public List<Task> getAll(){
        List<Task> taskList = repository.findAll();
        return taskList;
    }

    public void update(Task task){
        validator.exists(task.getId());
        repository.save(task);
    }

    public List<Task> search(
            String name,
            LocalDate startDate,
            LocalDate finishDate,
            LocalTime startTime,
            LocalTime finishTime
    ){
        Specification<Task> specs = Specification.allOf();
        if(name != null){
            specs = specs.and(TaskSpecs.nameLike(name));
        }
        if(startDate != null && finishDate != null){//get date period
            specs = specs.and(TaskSpecs.datePeriod(startDate, finishDate));
        }
        if(startDate != null && finishDate == null){//get tasks with startDate
            specs = specs.and(TaskSpecs.startDateEqual(startDate));
        }

        if(startTime != null && finishTime != null){//get time period
            specs = specs.and(TaskSpecs.timePeriod(startTime, finishTime));
        }
        if(startTime != null && finishTime == null){//get tasks with startTime
            specs = specs.and(TaskSpecs.startTimeEqual(startTime));
        }

        return repository.findAll(specs);
    }
}
