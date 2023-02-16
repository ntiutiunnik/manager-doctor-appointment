package com.demo.doctorappointmentmanager.controller;

import com.demo.doctorappointmentmanager.dto.BasicDto;
import com.demo.doctorappointmentmanager.mapper.AbstractMapper;
import com.demo.doctorappointmentmanager.model.BasicEntity;
import com.demo.doctorappointmentmanager.service.AbstractService;
import com.demo.doctorappointmentmanager.util.OffsetLimitPageable;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.demo.doctorappointmentmanager.util.resource.RestParams.ID_PATH_PARAM;

public abstract class AbstractCrudController<T extends BasicEntity<ID>, ID, DTO extends BasicDto<ID>, S extends AbstractService<T, ID, DTO, M, R>, M extends AbstractMapper<T, DTO>, R extends JpaRepository<T, ID>> {

    protected final S service;

    protected AbstractCrudController(S service) {
        this.service = service;
    }

    @GetMapping(
            produces = "application/json"
    )
    public ResponseEntity<List<DTO>> findAll(HttpServletRequest httpServletRequest) {
        List<DTO> entities = service.findAll(OffsetLimitPageable.of(httpServletRequest));
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @GetMapping(
            path = ID_PATH_PARAM,
            produces = "application/json"
    )
    public ResponseEntity<DTO> get(@PathVariable ID id) {
        DTO entity = service.findById(id);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PostMapping(
            consumes = "application/json"
    )
    public ResponseEntity<DTO> save(@RequestBody DTO dto) {
        DTO resultDto = service.save(dto);
        return new ResponseEntity<>(resultDto, HttpStatus.OK);
    }

    @DeleteMapping(
            path = ID_PATH_PARAM
    )
    public ResponseEntity<String> delete(@PathVariable ID id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
