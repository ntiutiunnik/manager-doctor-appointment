package com.demo.doctorappointmentmanager.service.impl;

import com.demo.doctorappointmentmanager.dto.DepartmentDto;
import com.demo.doctorappointmentmanager.mapper.DepartmentMapper;
import com.demo.doctorappointmentmanager.model.Department;
import com.demo.doctorappointmentmanager.repository.DepartmentRepository;
import com.demo.doctorappointmentmanager.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService extends AbstractService<Department, Long, DepartmentDto, DepartmentMapper, DepartmentRepository> {

    public DepartmentService(DepartmentMapper departmentMapper, DepartmentRepository departmentRepository) {
        super(departmentMapper, departmentRepository);
    }
}
