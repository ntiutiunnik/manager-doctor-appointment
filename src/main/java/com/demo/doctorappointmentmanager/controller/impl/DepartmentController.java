package com.demo.doctorappointmentmanager.controller.impl;

import com.demo.doctorappointmentmanager.controller.AbstractCrudController;
import com.demo.doctorappointmentmanager.dto.impl.DepartmentDto;
import com.demo.doctorappointmentmanager.mapper.impl.DepartmentMapper;
import com.demo.doctorappointmentmanager.model.Department;
import com.demo.doctorappointmentmanager.repository.DepartmentRepository;
import com.demo.doctorappointmentmanager.service.impl.DepartmentService;
import com.demo.doctorappointmentmanager.util.resource.GeneralResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GeneralResource.PATH + "/department")
public class DepartmentController extends AbstractCrudController<Department, Long, DepartmentDto, DepartmentService, DepartmentMapper, DepartmentRepository> {

    public DepartmentController(DepartmentService departmentService) {
        super(departmentService);
    }
}
