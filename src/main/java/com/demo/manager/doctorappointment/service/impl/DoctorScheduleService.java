package com.demo.manager.doctorappointment.service.impl;

import com.demo.manager.doctorappointment.dto.impl.DoctorScheduleDto;
import com.demo.manager.doctorappointment.mapper.impl.DoctorScheduleMapper;
import com.demo.manager.doctorappointment.model.impl.DoctorSchedule;
import com.demo.manager.doctorappointment.repository.impl.DoctorScheduleRepository;
import com.demo.manager.doctorappointment.service.AbstractService;
import com.demo.manager.doctorappointment.specification.DoctorScheduleSpecification;
import com.demo.manager.doctorappointment.specification.filter.DoctorScheduleFilterParam;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorScheduleService extends AbstractService<DoctorSchedule, Long, DoctorScheduleDto, DoctorScheduleMapper, DoctorScheduleRepository> {

    public DoctorScheduleService(DoctorScheduleMapper doctorScheduleMapper,
                                 DoctorScheduleRepository doctorScheduleRepository,
                                 ObjectMapper objectMapper) {
        super(doctorScheduleMapper, doctorScheduleRepository, objectMapper);
    }

    public List<DoctorScheduleDto> findAllDoctorSchedules(DoctorScheduleFilterParam doctorScheduleFilterParam, PageRequest pageRequest) {
        Page<DoctorSchedule> doctorSchedulePage = repository.findAll(DoctorScheduleSpecification.getFilteredDoctorSchedules(doctorScheduleFilterParam), pageRequest);
        return mapper.entitiesToDtos(doctorSchedulePage.getContent());
    }
}
