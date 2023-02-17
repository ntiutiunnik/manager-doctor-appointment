package com.demo.manager.doctorappointment.model.impl;

import com.demo.manager.doctorappointment.model.BasicEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import java.util.Objects;

@Entity
public class Appointment implements BasicEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_id_generator")
    @SequenceGenerator(name = "appointment_id_generator", sequenceName = "appointment_id_seq", allocationSize = 1)
    private Long id;

    @Generated(GenerationTime.INSERT)
    private Long number;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "doctor_schedule_id", referencedColumnName = "id")
    private DoctorSchedule doctorSchedule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

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

    public DoctorSchedule getDoctorSchedule() {
        return doctorSchedule;
    }

    public void setDoctorSchedule(DoctorSchedule doctorSchedule) {
        this.doctorSchedule = doctorSchedule;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
