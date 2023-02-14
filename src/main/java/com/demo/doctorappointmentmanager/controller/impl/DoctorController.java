package com.demo.doctorappointmentmanager.controller.impl;

import com.demo.doctorappointmentmanager.controller.AbstractCrudController;
import com.demo.doctorappointmentmanager.dto.DoctorDto;
import com.demo.doctorappointmentmanager.mapper.DoctorMapper;
import com.demo.doctorappointmentmanager.model.Doctor;
import com.demo.doctorappointmentmanager.repository.DoctorRepository;
import com.demo.doctorappointmentmanager.service.impl.DoctorService;
import com.demo.doctorappointmentmanager.specification.filter.DoctorFilterParam;
import com.demo.doctorappointmentmanager.util.OffsetLimitPageable;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController extends AbstractCrudController<Doctor, Long, DoctorDto, DoctorService, DoctorMapper, DoctorRepository> {

    public DoctorController(DoctorService doctorService) {
        super(doctorService);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<DoctorDto>> findAll(HttpServletRequest httpServletRequest) {
        List<DoctorDto> doctors = service.findAllDoctors(DoctorFilterParam.of(httpServletRequest), OffsetLimitPageable.of(httpServletRequest));

        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }
}
