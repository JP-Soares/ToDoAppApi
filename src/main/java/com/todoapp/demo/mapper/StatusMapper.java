package com.todoapp.demo.mapper;

import com.todoapp.demo.dto.request.StatusRequestDTO;
import com.todoapp.demo.dto.request.StatusRequestUpdateDTO;
import com.todoapp.demo.dto.response.StatusResponseDTO;
import com.todoapp.demo.model.Status;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StatusMapper {
    @Mapping(target = "user", ignore = true)
    Status toEntity(StatusRequestDTO dto);

    StatusResponseDTO toResponseDTO(Status status);


    StatusRequestUpdateDTO toReRequestupdateDTO(Status status);
    Status requestUpdateToEntity(StatusRequestUpdateDTO dto);
}
