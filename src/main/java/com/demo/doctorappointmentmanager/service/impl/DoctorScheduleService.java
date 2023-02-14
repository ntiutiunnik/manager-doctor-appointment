package com.demo.doctorappointmentmanager.service.impl;

import com.demo.doctorappointmentmanager.dto.DoctorScheduleDto;
import com.demo.doctorappointmentmanager.mapper.DoctorScheduleMapper;
import com.demo.doctorappointmentmanager.model.DoctorSchedule;
import com.demo.doctorappointmentmanager.repository.DoctorScheduleRepository;
import com.demo.doctorappointmentmanager.service.AbstractService;
import com.demo.doctorappointmentmanager.specification.DoctorScheduleSpecification;
import com.demo.doctorappointmentmanager.specification.filter.DoctorScheduleFilterParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorScheduleService extends AbstractService<DoctorSchedule, Long, DoctorScheduleDto, DoctorScheduleMapper, DoctorScheduleRepository> {

    public DoctorScheduleService(DoctorScheduleMapper doctorScheduleMapper,
                                 DoctorScheduleRepository doctorScheduleRepository) {
        super(doctorScheduleMapper, doctorScheduleRepository);
    }

    public List<DoctorScheduleDto> findAllDoctorSchedules(DoctorScheduleFilterParam doctorScheduleFilterParam, PageRequest pageRequest) {
        Page<DoctorSchedule> doctorSchedulePage = repository.findAll(DoctorScheduleSpecification.getFilteredDoctorSchedules(doctorScheduleFilterParam), pageRequest);

        return mapper.entitiesToDtos(doctorSchedulePage.getContent());
    }
}
