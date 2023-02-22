package com.demo.manager.doctorappointment.model.impl;

import com.demo.manager.doctorappointment.model.BasicEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Doctor implements BasicEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctor_id_generator")
    @SequenceGenerator(name = "doctor_id_generator", sequenceName = "doctor_id_seq", allocationSize = 1)
    private Long id;

    private String firstName;

    private String lastName;

    private Integer experienceYears;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "doctor")
    private List<DoctorSchedule> doctorScheduleList = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(id, doctor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<DoctorSchedule> getDoctorScheduleList() {
        return doctorScheduleList;
    }

    public void setDoctorScheduleList(List<DoctorSchedule> doctorScheduleList) {
        this.doctorScheduleList = doctorScheduleList;
    }
}
