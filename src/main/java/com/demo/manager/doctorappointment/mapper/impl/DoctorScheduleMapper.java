package com.demo.manager.doctorappointment.mapper.impl;

import com.demo.manager.doctorappointment.dto.impl.DoctorScheduleDto;
import com.demo.manager.doctorappointment.mapper.AbstractMapper;
import com.demo.manager.doctorappointment.mapper.config.DoctorAppointmentMapperConfig;
import com.demo.manager.doctorappointment.model.impl.DoctorSchedule;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(
        config = DoctorAppointmentMapperConfig.class,
        uses = {
                TimeSlotMapper.class,
                DoctorMapper.class
        })
@Component
public interface DoctorScheduleMapper extends AbstractMapper<DoctorSchedule, DoctorScheduleDto> {
}
