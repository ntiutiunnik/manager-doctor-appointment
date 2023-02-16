package com.demo.doctorappointmentmanager.service.impl;

import com.demo.doctorappointmentmanager.dto.impl.DoctorDto;
import com.demo.doctorappointmentmanager.mapper.impl.DoctorMapper;
import com.demo.doctorappointmentmanager.model.Doctor;
import com.demo.doctorappointmentmanager.repository.DoctorRepository;
import com.demo.doctorappointmentmanager.service.AbstractService;
import com.demo.doctorappointmentmanager.specification.DoctorSpecification;
import com.demo.doctorappointmentmanager.specification.filter.DoctorFilterParam;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService extends AbstractService<Doctor, Long, DoctorDto, DoctorMapper, DoctorRepository> {

    public DoctorService(DoctorMapper doctorMapper,
                         DoctorRepository doctorRepository,
                         EntityManager entityManager) {
        super(doctorMapper, doctorRepository, entityManager);
    }

    public List<DoctorDto> findAllDoctors(DoctorFilterParam doctorFilterParam, PageRequest pageRequest) {
        Page<Doctor> doctorPage = repository.findAll(DoctorSpecification.getFilteredDoctors(doctorFilterParam), pageRequest);

        return mapper.entitiesToDtos(doctorPage.getContent());
    }
}
