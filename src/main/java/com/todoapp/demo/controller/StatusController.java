package com.todoapp.demo.controller;

import com.todoapp.demo.dto.request.StatusRequestDTO;
import com.todoapp.demo.dto.request.StatusRequestUpdateDTO;
import com.todoapp.demo.dto.response.StatusResponseDTO;
import com.todoapp.demo.mapper.StatusMapper;
import com.todoapp.demo.model.Status;
import com.todoapp.demo.service.StatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<Object> update(@PathVariable("id") String id, @RequestBody StatusRequestUpdateDTO dto){
        return service.getById(UUID.fromString(id))
                .map(status -> {
                        Status statusAux = mapper.requestUpdateToEntity(dto);
                        status.setName(statusAux.getName());
                        status.setColor(statusAux.getColor());
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

    @GetMapping
    public ResponseEntity<List<StatusResponseDTO>> getAll(){
        List<Status> statusList= service.getAll();
        List<StatusResponseDTO> statusResponseDTOList = statusList.stream()
                .map(mapper::toResponseDTO)
                .toList();
        return ResponseEntity.ok(statusResponseDTOList);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") String id){
        try{
            service.delete(UUID.fromString(id));
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
