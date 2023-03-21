package com.demo.manager.doctorappointment.controller.impl;

import com.demo.manager.doctorappointment.controller.PagingCrudController;
import com.demo.manager.doctorappointment.service.PagingCrudService;
import com.demo.manager.doctorappointment.util.pagination.OffsetLimitPageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class PagingCrudControllerImpl<DTO, ID> implements PagingCrudController<DTO, ID> {

    protected final PagingCrudService<DTO, ID> service;

    protected PagingCrudControllerImpl(PagingCrudService<DTO, ID> service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<DTO>> getAll(Integer offset, Integer limit) {
        List<DTO> entities = service.findAll(OffsetLimitPageable.of(offset, limit));
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DTO> get(ID id) {
        DTO entity = service.findById(id);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DTO> save(@RequestBody DTO dto) {
        DTO resultDto = service.save(dto);
        return new ResponseEntity<>(resultDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> delete(@PathVariable ID id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
