package com.demo.manager.doctorappointment.controller.impl;

import com.demo.manager.doctorappointment.dto.impl.DoctorDto;
import com.demo.manager.doctorappointment.service.impl.DoctorService;
import com.demo.manager.doctorappointment.specification.filter.impl.DoctorFilterParam;
import com.demo.manager.doctorappointment.resource.GeneralResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GeneralResource.PATH + "/doctor")
public class DoctorController extends PagingAndFilteringCrudControllerImpl<DoctorDto, Long, DoctorFilterParam> {

    public DoctorController(DoctorService doctorService) {
        super(doctorService);
    }
}
