package com.demo.doctorappointmentmanager.controller;

import com.demo.doctorappointmentmanager.mapper.AbstractMapper;
import com.demo.doctorappointmentmanager.service.AbstractService;
import com.demo.doctorappointmentmanager.util.OffsetLimitPageable;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.demo.doctorappointmentmanager.util.resource.RestParams.ID_PATH_PARAM;

public abstract class AbstractCrudController<T, ID, DTO, S extends AbstractService<T, ID, DTO, M, R>, M extends AbstractMapper<T, DTO>, R extends JpaRepository<T, ID>> {

    protected final S service;

    protected AbstractCrudController(S service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DTO>> findAll(HttpServletRequest httpServletRequest) {
        List<DTO> entities = service.findAll(OffsetLimitPageable.of(httpServletRequest));
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @GetMapping(ID_PATH_PARAM)
    public ResponseEntity<DTO> get(@PathVariable ID id) {
        DTO entity = service.findById(id);
        if (entity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DTO> save(@RequestBody DTO entity) {
        DTO resultEntity = service.save(entity);
        return new ResponseEntity<>(resultEntity, HttpStatus.OK);
    }

    @DeleteMapping(path = ID_PATH_PARAM)
    public ResponseEntity<String> delete(@PathVariable ID id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
