package com.demo.doctorappointmentmanager.specification.filter;

import jakarta.servlet.http.HttpServletRequest;

import static com.demo.doctorappointmentmanager.util.RequestParamParser.getLongValue;

public class DoctorFilterParam {
    private Long departmentId;

    protected DoctorFilterParam(Long departmentId) {
        this.departmentId = departmentId;
    }

    public static DoctorFilterParam of(HttpServletRequest httpServletRequest) {
        Long departmentId = getLongValue(httpServletRequest, "department_id");
        return new DoctorFilterParam(departmentId);
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
