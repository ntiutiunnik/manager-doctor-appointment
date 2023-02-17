package com.demo.manager.doctorappointment.controller.impl;

import com.demo.manager.doctorappointment.controller.AbstractCrudController;
import com.demo.manager.doctorappointment.dto.impl.DepartmentDto;
import com.demo.manager.doctorappointment.mapper.impl.DepartmentMapper;
import com.demo.manager.doctorappointment.model.impl.Department;
import com.demo.manager.doctorappointment.repository.impl.DepartmentRepository;
import com.demo.manager.doctorappointment.service.impl.DepartmentService;
import com.demo.manager.doctorappointment.util.resource.GeneralResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GeneralResource.PATH + "/department")
public class DepartmentController extends AbstractCrudController<Department, Long, DepartmentDto, DepartmentService, DepartmentMapper, DepartmentRepository> {

    public DepartmentController(DepartmentService departmentService) {
        super(departmentService);
    }
}
