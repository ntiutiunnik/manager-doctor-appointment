package com.demo.doctorappointmentmanager.mapper.impl;

import com.demo.doctorappointmentmanager.dto.impl.DepartmentDto;
import com.demo.doctorappointmentmanager.mapper.AbstractMapper;
import com.demo.doctorappointmentmanager.mapper.config.DoctorAppointmentMapperConfig;
import com.demo.doctorappointmentmanager.model.Department;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(config = DoctorAppointmentMapperConfig.class)
@Component
public interface DepartmentMapper extends AbstractMapper<Department, DepartmentDto> {
}
