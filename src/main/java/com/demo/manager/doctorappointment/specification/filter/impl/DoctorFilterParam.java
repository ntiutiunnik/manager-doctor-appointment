package com.demo.manager.doctorappointment.specification.filter.impl;

import com.demo.manager.doctorappointment.specification.filter.FilterParam;
import io.swagger.v3.oas.annotations.Parameter;

public class DoctorFilterParam extends FilterParam {
    @Parameter(name = "department_id")
    private Long departmentId;

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
