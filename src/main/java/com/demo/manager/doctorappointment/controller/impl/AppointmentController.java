package com.demo.manager.doctorappointment.controller.impl;

import com.demo.manager.doctorappointment.controller.AbstractCrudController;
import com.demo.manager.doctorappointment.dto.impl.AppointmentDto;
import com.demo.manager.doctorappointment.mapper.impl.AppointmentMapper;
import com.demo.manager.doctorappointment.model.impl.Appointment;
import com.demo.manager.doctorappointment.repository.impl.AppointmentRepository;
import com.demo.manager.doctorappointment.service.impl.AppointmentService;
import com.demo.manager.doctorappointment.specification.filter.AppointmentFilterParam;
import com.demo.manager.doctorappointment.util.OffsetLimitPageable;
import com.demo.manager.doctorappointment.util.resource.GeneralResource;
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
