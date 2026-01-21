package com.todoapp.demo.controller;

import com.todoapp.demo.dto.StatusDTO;
import com.todoapp.demo.mapper.StatusMapper;
import com.todoapp.demo.model.Status;
import com.todoapp.demo.service.StatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("status")
@RequiredArgsConstructor
public class StatusController {
    final private StatusService service;
    final private StatusMapper mapper;

    @PostMapping
    public ResponseEntity<Object> save (@RequestBody StatusDTO dto){
        Status status = mapper.toEntity(dto);
        service.save(status, dto.user());

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body("Success!");
    }
}
