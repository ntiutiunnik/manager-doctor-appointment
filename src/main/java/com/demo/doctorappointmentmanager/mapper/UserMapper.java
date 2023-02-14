package com.demo.doctorappointmentmanager.mapper;

import com.demo.doctorappointmentmanager.dto.UserDto;
import com.demo.doctorappointmentmanager.mapper.config.DoctorAppointmentMapperConfig;
import com.demo.doctorappointmentmanager.model.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(config = DoctorAppointmentMapperConfig.class)
@Component
public interface UserMapper extends AbstractMapper<User, UserDto> {
}
