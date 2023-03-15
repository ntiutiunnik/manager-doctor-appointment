package com.demo.manager.doctorappointment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface PostController<DTO> {

    @PostMapping(
            consumes = "application/json"
    )
    ResponseEntity<DTO> save(@RequestBody DTO dto);
}
