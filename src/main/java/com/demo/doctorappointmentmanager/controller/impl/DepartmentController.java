package com.demo.doctorappointmentmanager.controller.impl;

import com.demo.doctorappointmentmanager.controller.AbstractCrudController;
import com.demo.doctorappointmentmanager.dto.DepartmentDto;
import com.demo.doctorappointmentmanager.mapper.DepartmentMapper;
import com.demo.doctorappointmentmanager.model.Department;
import com.demo.doctorappointmentmanager.repository.DepartmentRepository;
import com.demo.doctorappointmentmanager.service.impl.DepartmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController extends AbstractCrudController<Department, Long, DepartmentDto, DepartmentService, DepartmentMapper, DepartmentRepository> {

    public DepartmentController(DepartmentService departmentService) {
        super(departmentService);
    }
}
