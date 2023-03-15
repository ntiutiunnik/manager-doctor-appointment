package com.demo.manager.doctorappointment.service;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PagingCrudService<DTO, ID> extends CrudService<DTO, ID> {

    List<DTO> findAll(Pageable pageable);
}
