package com.demo.manager.doctorappointment.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface PagingAndFilteringCrudController<DTO, ID, F> extends CrudController<DTO, ID> {

    @GetMapping(
            produces = "application/json"
    )
    @Parameter(
            name = "offset",
            in = ParameterIn.QUERY,
            schema = @Schema(type = "integer", defaultValue = "0", example = "5")
    )
    @Parameter(
            name = "limit",
            in = ParameterIn.QUERY,
            schema = @Schema(type = "integer", defaultValue = "25", example = "25")
    )
    ResponseEntity<List<DTO>> getAll(Integer offset, Integer limit, @ParameterObject F filterParam);
}
