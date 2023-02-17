package com.demo.manager.doctorappointment.dto.impl;

import com.demo.manager.doctorappointment.dto.BasicDto;

public class DepartmentDto implements BasicDto<Long> {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
