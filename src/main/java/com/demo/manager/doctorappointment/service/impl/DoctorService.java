package com.demo.manager.doctorappointment.service.impl;

import com.demo.manager.doctorappointment.dto.impl.DoctorDto;
import com.demo.manager.doctorappointment.mapper.impl.DoctorMapper;
import com.demo.manager.doctorappointment.model.impl.Doctor;
import com.demo.manager.doctorappointment.repository.impl.DoctorRepository;
import com.demo.manager.doctorappointment.service.AbstractService;
import com.demo.manager.doctorappointment.specification.DoctorSpecification;
import com.demo.manager.doctorappointment.specification.filter.DoctorFilterParam;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService extends AbstractService<Doctor, Long, DoctorDto, DoctorMapper, DoctorRepository> {

    public DoctorService(DoctorMapper doctorMapper,
                         DoctorRepository doctorRepository,
                         ObjectMapper objectMapper) {
        super(doctorMapper, doctorRepository, objectMapper);
    }

    public List<DoctorDto> findAllDoctors(DoctorFilterParam doctorFilterParam, PageRequest pageRequest) {
        Page<Doctor> doctorPage = repository.findAll(DoctorSpecification.getFilteredDoctors(doctorFilterParam), pageRequest);

        return mapper.entitiesToDtos(doctorPage.getContent());
    }
}
