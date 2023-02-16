package com.demo.doctorappointmentmanager.controller.impl;

import com.demo.doctorappointmentmanager.controller.AbstractCrudController;
import com.demo.doctorappointmentmanager.dto.impl.AppointmentDto;
import com.demo.doctorappointmentmanager.mapper.impl.AppointmentMapper;
import com.demo.doctorappointmentmanager.model.Appointment;
import com.demo.doctorappointmentmanager.repository.AppointmentRepository;
import com.demo.doctorappointmentmanager.service.impl.AppointmentService;
import com.demo.doctorappointmentmanager.specification.filter.AppointmentFilterParam;
import com.demo.doctorappointmentmanager.util.OffsetLimitPageable;
import com.demo.doctorappointmentmanager.util.resource.GeneralResource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(GeneralResource.PATH + "/appointment")
public class AppointmentController extends AbstractCrudController<Appointment, Long, AppointmentDto, AppointmentService, AppointmentMapper, AppointmentRepository> {

    public AppointmentController(AppointmentService appointmentService) {
        super(appointmentService);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<AppointmentDto>> findAll(HttpServletRequest httpServletRequest) {
        List<AppointmentDto> appointments = service.findAllAppointments(AppointmentFilterParam.of(httpServletRequest), OffsetLimitPageable.of(httpServletRequest));

        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }
}
