package com.demo.doctorappointmentmanager.service.impl;

import com.demo.doctorappointmentmanager.dto.impl.DepartmentDto;
import com.demo.doctorappointmentmanager.mapper.impl.DepartmentMapper;
import com.demo.doctorappointmentmanager.model.Department;
import com.demo.doctorappointmentmanager.repository.DepartmentRepository;
import com.demo.doctorappointmentmanager.service.AbstractService;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService extends AbstractService<Department, Long, DepartmentDto, DepartmentMapper, DepartmentRepository> {

    public DepartmentService(DepartmentMapper departmentMapper,
                             DepartmentRepository departmentRepository,
                             EntityManager entityManager) {
        super(departmentMapper, departmentRepository, entityManager);
    }
}
