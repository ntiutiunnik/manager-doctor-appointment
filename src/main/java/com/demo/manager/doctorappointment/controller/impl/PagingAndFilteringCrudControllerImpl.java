package com.demo.manager.doctorappointment.controller.impl;

import com.demo.manager.doctorappointment.controller.PagingAndFilteringCrudController;
import com.demo.manager.doctorappointment.service.PagingAndFilteringCrudService;
import com.demo.manager.doctorappointment.specification.filter.FilterParam;
import com.demo.manager.doctorappointment.util.pagination.OffsetLimitPageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class PagingAndFilteringCrudControllerImpl<DTO, ID, F extends FilterParam> implements PagingAndFilteringCrudController<DTO, ID, F> {

    protected final PagingAndFilteringCrudService<DTO, ID, F> service;

    protected PagingAndFilteringCrudControllerImpl(PagingAndFilteringCrudService<DTO, ID, F> service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<DTO>> getAll(Integer offset, Integer limit, F filterParam) {
        List<DTO> entities = service.findAll(OffsetLimitPageable.of(offset, limit), filterParam);
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
