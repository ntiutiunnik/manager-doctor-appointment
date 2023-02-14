package com.demo.doctorappointmentmanager.mapper;

import com.demo.doctorappointmentmanager.dto.DoctorScheduleDto;
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
