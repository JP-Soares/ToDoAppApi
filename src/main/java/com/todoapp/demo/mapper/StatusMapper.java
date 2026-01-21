package com.todoapp.demo.mapper;

import com.todoapp.demo.dto.StatusDTO;
import com.todoapp.demo.model.Status;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StatusMapper {
    @Mapping(target = "user", ignore = true)
    Status toEntity(StatusDTO dto);
}
