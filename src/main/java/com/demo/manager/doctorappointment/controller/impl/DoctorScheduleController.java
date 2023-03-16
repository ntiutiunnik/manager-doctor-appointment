package com.demo.manager.doctorappointment.controller.impl;

import com.demo.manager.doctorappointment.dto.impl.DoctorScheduleDto;
import com.demo.manager.doctorappointment.service.impl.DoctorScheduleService;
import com.demo.manager.doctorappointment.specification.filter.impl.DoctorScheduleFilterParam;
import com.demo.manager.doctorappointment.resource.GeneralResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GeneralResource.PATH + "/doctor_schedule")
public class DoctorScheduleController extends PagingAndFilteringCrudControllerImpl<DoctorScheduleDto, Long, DoctorScheduleFilterParam> {

    public DoctorScheduleController(DoctorScheduleService doctorScheduleService) {
        super(doctorScheduleService);
    }
}
