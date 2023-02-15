package com.demo.doctorappointmentmanager.controller.impl;

import com.demo.doctorappointmentmanager.controller.AbstractCrudController;
import com.demo.doctorappointmentmanager.dto.impl.DoctorScheduleDto;
import com.demo.doctorappointmentmanager.mapper.impl.DoctorScheduleMapper;
import com.demo.doctorappointmentmanager.model.DoctorSchedule;
import com.demo.doctorappointmentmanager.repository.DoctorScheduleRepository;
import com.demo.doctorappointmentmanager.service.impl.DoctorScheduleService;
import com.demo.doctorappointmentmanager.specification.filter.DoctorScheduleFilterParam;
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
@RequestMapping(GeneralResource.PATH + "/doctor_schedule")
public class DoctorScheduleController extends AbstractCrudController<DoctorSchedule, Long, DoctorScheduleDto, DoctorScheduleService, DoctorScheduleMapper, DoctorScheduleRepository> {

    public DoctorScheduleController(DoctorScheduleService doctorScheduleService) {
        super(doctorScheduleService);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<DoctorScheduleDto>> findAll(HttpServletRequest httpServletRequest) {
        List<DoctorScheduleDto> doctorScheduleDtos = service.findAllDoctorSchedules(DoctorScheduleFilterParam.of(httpServletRequest), OffsetLimitPageable.of(httpServletRequest));

        return new ResponseEntity<>(doctorScheduleDtos, HttpStatus.OK);
    }
}
