package com.demo.doctorappointmentmanager.mapper;

import com.demo.doctorappointmentmanager.dto.DepartmentDto;
import com.demo.doctorappointmentmanager.mapper.config.DoctorAppointmentMapperConfig;
import com.demo.doctorappointmentmanager.model.Department;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(config = DoctorAppointmentMapperConfig.class)
@Component
public interface DepartmentMapper extends AbstractMapper<Department, DepartmentDto> {
}
