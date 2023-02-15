package com.demo.doctorappointmentmanager.mapper.impl;

import com.demo.doctorappointmentmanager.dto.impl.DoctorScheduleDto;
import com.demo.doctorappointmentmanager.mapper.AbstractMapper;
import com.demo.doctorappointmentmanager.mapper.config.DoctorAppointmentMapperConfig;
import com.demo.doctorappointmentmanager.model.DoctorSchedule;
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
