package com.todoapp.demo.mapper;

import com.todoapp.demo.dto.request.SubTaskRequestDTO;
import com.todoapp.demo.dto.response.SubTaskResponseDTO;
import com.todoapp.demo.model.SubTask;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "string")
public interface SubTaskMapper {
    @Mapping(target="task", ignore=true)
    SubTask toEntity(SubTaskRequestDTO dto);

    SubTaskResponseDTO toResponseDTO(SubTask subTask);
}
