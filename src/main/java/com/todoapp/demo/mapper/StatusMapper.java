package com.todoapp.demo.mapper;

import com.todoapp.demo.dto.StatusDTO;
import com.todoapp.demo.model.Status;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatusMapper {
    Status toEntity(StatusDTO dto);
}
