package com.demo.doctorappointmentmanager.specification.filter;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;

//make abstract?
public class DoctorFilterParam {
    private Long departmentId;

    protected DoctorFilterParam(Long departmentId) {
        this.departmentId = departmentId;
    }

    public static DoctorFilterParam of(HttpServletRequest httpServletRequest) {
        String departmentIdString = httpServletRequest.getParameter("department_id");
        Long departmentId = StringUtils.isEmpty(departmentIdString) ? null : Long.parseLong(departmentIdString);

        return new DoctorFilterParam(departmentId);
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
