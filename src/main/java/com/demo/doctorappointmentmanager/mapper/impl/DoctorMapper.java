package com.demo.doctorappointmentmanager.mapper.impl;

import com.demo.doctorappointmentmanager.dto.impl.DoctorDto;
import com.demo.doctorappointmentmanager.mapper.AbstractMapper;
import com.demo.doctorappointmentmanager.mapper.config.DoctorAppointmentMapperConfig;
import com.demo.doctorappointmentmanager.model.Doctor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(
        config = DoctorAppointmentMapperConfig.class,
        uses = DepartmentMapper.class
)
@Component
public interface DoctorMapper extends AbstractMapper<Doctor, DoctorDto> {
}
