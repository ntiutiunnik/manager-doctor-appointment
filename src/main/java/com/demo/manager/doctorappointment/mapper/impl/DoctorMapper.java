package com.demo.manager.doctorappointment.mapper.impl;

import com.demo.manager.doctorappointment.dto.impl.DoctorDto;
import com.demo.manager.doctorappointment.mapper.AbstractMapper;
import com.demo.manager.doctorappointment.mapper.config.DoctorAppointmentMapperConfig;
import com.demo.manager.doctorappointment.model.impl.Doctor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(
        config = DoctorAppointmentMapperConfig.class,
        uses = DepartmentMapper.class
)
@Component
public interface DoctorMapper extends AbstractMapper<Doctor, DoctorDto> {
}
