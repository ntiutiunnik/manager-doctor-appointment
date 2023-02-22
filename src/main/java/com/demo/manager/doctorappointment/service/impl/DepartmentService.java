package com.demo.manager.doctorappointment.service.impl;

import com.demo.manager.doctorappointment.dto.impl.DepartmentDto;
import com.demo.manager.doctorappointment.mapper.impl.DepartmentMapper;
import com.demo.manager.doctorappointment.model.impl.Department;
import com.demo.manager.doctorappointment.repository.impl.DepartmentRepository;
import com.demo.manager.doctorappointment.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService extends AbstractService<Department, Long, DepartmentDto, DepartmentMapper, DepartmentRepository> {

    public DepartmentService(DepartmentMapper departmentMapper,
                             DepartmentRepository departmentRepository) {
        super(departmentMapper, departmentRepository);
    }
}
