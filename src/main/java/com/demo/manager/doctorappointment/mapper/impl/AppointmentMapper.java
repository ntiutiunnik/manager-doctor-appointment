package com.demo.manager.doctorappointment.mapper.impl;

import com.demo.manager.doctorappointment.dto.impl.AppointmentDto;
import com.demo.manager.doctorappointment.mapper.AbstractMapper;
import com.demo.manager.doctorappointment.mapper.config.DoctorAppointmentMapperConfig;
import com.demo.manager.doctorappointment.model.impl.Appointment;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(
        config = DoctorAppointmentMapperConfig.class,
        uses = {
                DoctorScheduleMapper.class,
                AccountMapper.class
        }
)
@Component
public interface AppointmentMapper extends AbstractMapper<Appointment, AppointmentDto> {
}
