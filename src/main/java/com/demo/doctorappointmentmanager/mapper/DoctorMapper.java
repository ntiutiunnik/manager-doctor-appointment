package com.demo.doctorappointmentmanager.mapper;

import com.demo.doctorappointmentmanager.dto.DoctorDto;
import com.demo.doctorappointmentmanager.mapper.config.DoctorAppointmentMapperConfig;
import com.demo.doctorappointmentmanager.model.Doctor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(config = DoctorAppointmentMapperConfig.class)
@Component
public interface DoctorMapper extends AbstractMapper<Doctor, DoctorDto> {
}
