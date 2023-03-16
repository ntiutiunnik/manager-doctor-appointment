package com.demo.manager.doctorappointment.specification.filter.impl;

import com.demo.manager.doctorappointment.specification.filter.FilterParam;
import io.swagger.v3.oas.annotations.Parameter;

import java.beans.ConstructorProperties;

public class DoctorFilterParam implements FilterParam {

    @Parameter(name = "department_id")
    private Long departmentId;

    @ConstructorProperties({"department_id"})
    public DoctorFilterParam(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
