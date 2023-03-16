package com.demo.manager.doctorappointment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static com.demo.tools.doctorappointment.autoconfigure.util.api.RestParams.ID_PATH_PARAM;

public interface DeleteController<ID> {

    @DeleteMapping(
            path = ID_PATH_PARAM
    )
    ResponseEntity<String> delete(@PathVariable ID id);
}
