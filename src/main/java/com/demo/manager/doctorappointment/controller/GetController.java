package com.demo.manager.doctorappointment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static com.demo.tools.doctorappointment.autoconfigure.util.api.RestParams.ID_PATH_PARAM;


public interface GetController<DTO, ID> {

    @GetMapping(
            path = ID_PATH_PARAM,
            produces = "application/json"
    )
    ResponseEntity<DTO> get(@PathVariable ID id);
}
