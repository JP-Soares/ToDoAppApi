package com.todoapp.demo.mapper;

import com.todoapp.demo.dto.request.TaskRequestPostDTO;
import com.todoapp.demo.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaksMapper {

    @Mapping(target="user")
    @Mapping(target="status")
    Task requestPostToEntity(TaskRequestPostDTO dto);
}
