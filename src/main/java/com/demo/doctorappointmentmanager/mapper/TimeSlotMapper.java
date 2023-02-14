package com.demo.doctorappointmentmanager.mapper;

import com.demo.doctorappointmentmanager.dto.TimeSlotDto;
import com.demo.doctorappointmentmanager.mapper.config.DoctorAppointmentMapperConfig;
import com.demo.doctorappointmentmanager.model.TimeSlot;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(config = DoctorAppointmentMapperConfig.class)
@Component
public interface TimeSlotMapper extends AbstractMapper<TimeSlot, TimeSlotDto> {
}
