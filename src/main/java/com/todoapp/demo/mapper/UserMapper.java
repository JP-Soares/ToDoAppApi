package com.todoapp.demo.mapper;

import com.todoapp.demo.dto.request.UserRequestDTO;
import com.todoapp.demo.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserRequestDTO dto);
}
