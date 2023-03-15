package com.demo.manager.doctorappointment.service.impl;

import com.demo.manager.doctorappointment.dto.impl.DoctorScheduleDto;
import com.demo.manager.doctorappointment.mapper.impl.DoctorScheduleMapper;
import com.demo.manager.doctorappointment.model.impl.DoctorSchedule;
import com.demo.manager.doctorappointment.repository.impl.DoctorScheduleRepository;
import com.demo.manager.doctorappointment.specification.impl.DoctorScheduleSpecificationUtils;
import com.demo.manager.doctorappointment.specification.filter.impl.DoctorScheduleFilterParam;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class DoctorScheduleService extends PagingAndFilteringCrudServiceImpl<DoctorScheduleDto, Long, DoctorSchedule, DoctorScheduleFilterParam, DoctorScheduleMapper, DoctorScheduleRepository> {

    public DoctorScheduleService(DoctorScheduleMapper doctorScheduleMapper,
                                 DoctorScheduleRepository doctorScheduleRepository,
                                 DoctorScheduleSpecificationUtils doctorScheduleSpecificationUtils,
                                 ObjectMapper objectMapper) {
        super(doctorScheduleMapper, doctorScheduleRepository, doctorScheduleSpecificationUtils, objectMapper);
    }
}
