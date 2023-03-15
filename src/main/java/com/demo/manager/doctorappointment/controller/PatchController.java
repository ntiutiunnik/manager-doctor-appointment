package com.demo.manager.doctorappointment.controller;

import com.github.fge.jsonpatch.JsonPatch;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import static com.demo.manager.doctorappointment.util.resource.RestParams.ID_PATH_PARAM;

public interface PatchController<DTO, ID> {

    @PatchMapping(
            path = ID_PATH_PARAM,
            consumes = "application/json-patch+json",
            produces = "application/json"
    )
    ResponseEntity<DTO> update(@PathVariable ID id, @RequestBody JsonPatch patch);
}
