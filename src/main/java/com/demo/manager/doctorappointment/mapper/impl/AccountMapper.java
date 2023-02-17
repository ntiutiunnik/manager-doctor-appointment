package com.demo.manager.doctorappointment.mapper.impl;

import com.demo.manager.doctorappointment.dto.impl.AccountDto;
import com.demo.manager.doctorappointment.mapper.AbstractMapper;
import com.demo.manager.doctorappointment.mapper.config.DoctorAppointmentMapperConfig;
import com.demo.manager.doctorappointment.model.impl.Account;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(config = DoctorAppointmentMapperConfig.class)
@Component
public interface AccountMapper extends AbstractMapper<Account, AccountDto> {
}
