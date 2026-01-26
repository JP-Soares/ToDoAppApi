package com.todoapp.demo.controller;

import com.todoapp.demo.dto.request.TaskRequestPostDTO;
import com.todoapp.demo.dto.response.TaskResponseDTO;
import com.todoapp.demo.mapper.TaskMapper;
import com.todoapp.demo.model.Task;
import com.todoapp.demo.service.TaskService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;
    private final TaskMapper mapper;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody TaskRequestPostDTO dto){
        Task task = mapper.requestPostToEntity(dto);
        service.save(task, dto.status(), dto.user());

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body("Success!");
    }

    @GetMapping("{id}")
    public ResponseEntity<TaskResponseDTO> getById(@PathVariable("id") String id){
        Task task = service.getById(UUID.fromString(id)).orElseThrow(()-> new EntityNotFoundException("Task not found!"));
        TaskResponseDTO dto = mapper.entityToResponseDTO(task);

        return ResponseEntity.ok(dto);
    }
}
