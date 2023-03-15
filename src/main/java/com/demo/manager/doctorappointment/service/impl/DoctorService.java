package com.demo.manager.doctorappointment.service.impl;

import com.demo.manager.doctorappointment.dto.impl.DoctorDto;
import com.demo.manager.doctorappointment.mapper.impl.DoctorMapper;
import com.demo.manager.doctorappointment.model.impl.Doctor;
import com.demo.manager.doctorappointment.repository.impl.DoctorRepository;
import com.demo.manager.doctorappointment.specification.impl.DoctorSpecificationUtils;
import com.demo.manager.doctorappointment.specification.filter.impl.DoctorFilterParam;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class DoctorService extends PagingAndFilteringCrudServiceImpl<DoctorDto, Long, Doctor, DoctorFilterParam, DoctorMapper, DoctorRepository> {

    public DoctorService(DoctorMapper doctorMapper,
                         DoctorRepository doctorRepository,
                         DoctorSpecificationUtils doctorSpecificationUtils,
                         ObjectMapper objectMapper) {
        super(doctorMapper, doctorRepository, doctorSpecificationUtils, objectMapper);
    }
}
