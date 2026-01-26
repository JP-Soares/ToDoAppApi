package com.todoapp.demo.controller;

import com.todoapp.demo.dto.request.TaskRequestPostDTO;
import com.todoapp.demo.dto.request.TaskRequestUpdateDTO;
import com.todoapp.demo.dto.response.TaskResponseDTO;
import com.todoapp.demo.exceptions.NotFound;
import com.todoapp.demo.mapper.TaskMapper;
import com.todoapp.demo.model.Status;
import com.todoapp.demo.model.Task;
import com.todoapp.demo.service.StatusService;
import com.todoapp.demo.service.TaskService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;
    private final TaskMapper mapper;
    private final StatusService statusService;

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

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getAll(){
        List<Task> taskList = service.getAll();
        List<TaskResponseDTO> taskResponseDTOList = taskList.stream()
                .map(mapper::entityToResponseDTO).
                toList();
        return ResponseEntity.ok(taskResponseDTOList);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable("id") String id, @RequestBody TaskRequestUpdateDTO dto){
        try{
            return service.getById(UUID.fromString(id)).map(
                    task -> {
                        Task taskAux = mapper.requestUpdateToEntity(dto);
                        task.setName(dto.name());
                        task.setColor(dto.color());
                        task.setStartDate(dto.startDate());
                        task.setFinishDate(dto.finishDate());
                        task.setStartTime(dto.startTime());
                        task.setFinishTime(dto.finishTime());

                        Status status = statusService.getById(dto.status()).
                                orElseThrow(() -> new NotFound("Status not found!"));//get the status
                        task.setStatus(status);//set the status

                        service.update(task);
                        return ResponseEntity.noContent().build();
                    }
            ).orElseGet(() -> ResponseEntity.notFound().build());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
