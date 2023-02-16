package com.demo.doctorappointmentmanager.service.impl;

import com.demo.doctorappointmentmanager.dto.impl.DoctorScheduleDto;
import com.demo.doctorappointmentmanager.mapper.impl.DoctorScheduleMapper;
import com.demo.doctorappointmentmanager.model.DoctorSchedule;
import com.demo.doctorappointmentmanager.repository.DoctorScheduleRepository;
import com.demo.doctorappointmentmanager.service.AbstractService;
import com.demo.doctorappointmentmanager.specification.DoctorScheduleSpecification;
import com.demo.doctorappointmentmanager.specification.filter.DoctorScheduleFilterParam;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorScheduleService extends AbstractService<DoctorSchedule, Long, DoctorScheduleDto, DoctorScheduleMapper, DoctorScheduleRepository> {

    public DoctorScheduleService(DoctorScheduleMapper doctorScheduleMapper,
                                 DoctorScheduleRepository doctorScheduleRepository,
                                 EntityManager entityManager) {
        super(doctorScheduleMapper, doctorScheduleRepository, entityManager);
    }

    public List<DoctorScheduleDto> findAllDoctorSchedules(DoctorScheduleFilterParam doctorScheduleFilterParam, PageRequest pageRequest) {
        Page<DoctorSchedule> doctorSchedulePage = repository.findAll(DoctorScheduleSpecification.getFilteredDoctorSchedules(doctorScheduleFilterParam), pageRequest);
        return mapper.entitiesToDtos(doctorSchedulePage.getContent());
    }
}
