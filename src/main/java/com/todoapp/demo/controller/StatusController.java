package com.todoapp.demo.controller;

import com.todoapp.demo.dto.request.StatusRequestDTO;
import com.todoapp.demo.dto.response.StatusResponseDTO;
import com.todoapp.demo.mapper.StatusMapper;
import com.todoapp.demo.model.Status;
import com.todoapp.demo.service.StatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("status")
@RequiredArgsConstructor
public class StatusController {
    final private StatusService service;
    final private StatusMapper mapper;

    @PostMapping
    public ResponseEntity<Object> save (@RequestBody StatusRequestDTO dto){
        Status status = mapper.toEntity(dto);
        service.save(status, dto.user());

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body("Success!");
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable("id") String id, @RequestBody StatusRequestDTO dto){
        return service.getById(UUID.fromString(id))
                .map(status -> {
                        Status statusAux = mapper.toEntity(dto);
                        status.setName(statusAux.getName());
                        status.setColor(statusAux.getColor());
                        status.setUser(statusAux.getUser());
                        System.out.println(statusAux);
                        service.update(status);
                        return ResponseEntity.noContent().build();
                    }
                ).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("{id}")
    public ResponseEntity<StatusResponseDTO> getById(@PathVariable("id") String id){
        return service.getById(UUID.fromString(id))
                .map(status -> {
                    var dto = mapper.toResponseDTO(status);
                    return ResponseEntity.ok(dto);
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
