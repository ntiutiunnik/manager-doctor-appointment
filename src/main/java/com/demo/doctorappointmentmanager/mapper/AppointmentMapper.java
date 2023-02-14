package com.demo.doctorappointmentmanager.mapper;

import com.demo.doctorappointmentmanager.dto.AppointmentDto;
import com.demo.doctorappointmentmanager.mapper.config.DoctorAppointmentMapperConfig;
import com.demo.doctorappointmentmanager.model.Appointment;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(config = DoctorAppointmentMapperConfig.class)
@Component
public interface AppointmentMapper extends AbstractMapper<Appointment, AppointmentDto> {
}
