package com.todoapp.demo.mapper;

import com.todoapp.demo.dto.request.TaskRequestPostDTO;
import com.todoapp.demo.dto.response.TaskResponseDTO;
import com.todoapp.demo.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(target="user", ignore = true)
    @Mapping(target="status", ignore = true)
    Task requestPostToEntity(TaskRequestPostDTO dto);

    TaskResponseDTO entityToResponseDTO(Task task);
}
