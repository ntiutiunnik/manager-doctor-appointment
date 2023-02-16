package com.demo.doctorappointmentmanager.dto.impl;

import com.demo.doctorappointmentmanager.dto.BasicDto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AppointmentDto implements BasicDto<Long> {

    private Long id;

    private Long number;

    @JsonProperty("doctor schedule")
    private DoctorScheduleDto doctorSchedule;

    private AccountDto account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public DoctorScheduleDto getDoctorSchedule() {
        return doctorSchedule;
    }

    public void setDoctorSchedule(DoctorScheduleDto doctorScheduleDto) {
        this.doctorSchedule = doctorScheduleDto;
    }

    public AccountDto getAccount() {
        return account;
    }

    public void setAccount(AccountDto accountDto) {
        this.account = accountDto;
    }
}
