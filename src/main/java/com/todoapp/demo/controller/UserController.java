package com.todoapp.demo.controller;

import com.todoapp.demo.dto.request.UserRequestDTO;
import com.todoapp.demo.mapper.UserMapper;
import com.todoapp.demo.model.User;
import com.todoapp.demo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController implements GenericController{
    private final UserService service;
    private final UserMapper mapper;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid UserRequestDTO dto){
        User user = mapper.toEntity(dto);
        service.save(user);

        System.out.println("DTO: "+dto);

        var url = generateHeaderLocation(user.getId());
        return ResponseEntity.created(url).build();
    }

//    @GetMapping("{id}")
//    public ResponseEntity<Object> getById(@PathVariable("id") String id){
//
//    }
}
