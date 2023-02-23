package com.demo.manager.doctorappointment.specification.filter;

import com.demo.manager.doctorappointment.util.RequestParamParser;

import javax.servlet.http.HttpServletRequest;

public class DoctorFilterParam {
    private Long departmentId;

    protected DoctorFilterParam(Long departmentId) {
        this.departmentId = departmentId;
    }

    public static DoctorFilterParam of(HttpServletRequest httpServletRequest) {
        Long departmentId = RequestParamParser.getLongValue(httpServletRequest, "department_id");
        return new DoctorFilterParam(departmentId);
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
