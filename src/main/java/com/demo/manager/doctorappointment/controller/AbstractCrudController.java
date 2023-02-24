package com.demo.manager.doctorappointment.controller;

import com.demo.manager.doctorappointment.dto.BasicDto;
import com.demo.manager.doctorappointment.mapper.AbstractMapper;
import com.demo.manager.doctorappointment.model.BasicEntity;
import com.demo.manager.doctorappointment.repository.CustomTransactionalRepository;
import com.demo.manager.doctorappointment.service.AbstractService;
import com.demo.manager.doctorappointment.util.OffsetLimitPageable;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.demo.manager.doctorappointment.util.resource.RestParams.ID_PATH_PARAM;

public abstract class AbstractCrudController<T extends BasicEntity<ID>, ID, DTO extends BasicDto<ID>, S extends AbstractService<T, ID, DTO, M, R>, M extends AbstractMapper<T, DTO>, R extends CustomTransactionalRepository<T, ID>> {

    protected final S service;

    protected AbstractCrudController(S service) {
        this.service = service;
    }

    @GetMapping(
            produces = "application/json"
    )
    @Parameters({
            @Parameter(
                    name = "offset",
                    in = ParameterIn.QUERY,
                    schema = @Schema(type = "integer", defaultValue = "0", example = "5")
            ),
            @Parameter(
                    name = "limit",
                    in = ParameterIn.QUERY,
                    schema = @Schema(type = "integer", defaultValue = "25", example = "25")
            )
    })
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
