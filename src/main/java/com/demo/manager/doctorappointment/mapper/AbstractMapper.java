package com.demo.manager.doctorappointment.mapper;

import java.util.List;

public interface AbstractMapper<T, DTO> {

    T dtoToEntity(DTO dto);

    DTO entityToDto(T entity);

    List<T> dtosToEntities(List<DTO> dtos);

    List<DTO> entitiesToDtos(List<T> entities);
}
