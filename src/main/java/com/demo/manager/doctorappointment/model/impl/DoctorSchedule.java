package com.demo.manager.doctorappointment.model.impl;

import com.demo.manager.doctorappointment.model.BasicEntity;
import javax.persistence.*;

import java.util.Objects;

@Entity
public class DoctorSchedule implements BasicEntity<DoctorSchedule, Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctor_schedule_id_generator")
    @SequenceGenerator(name = "doctor_schedule_id_generator", sequenceName = "doctor_schedule_id_seq", allocationSize = 1)
    private Long id;

    @OneToOne(mappedBy = "doctorSchedule", fetch = FetchType.LAZY)
    private Appointment appointment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "time_slot_id")
    private TimeSlot timeSlot;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorSchedule that = (DoctorSchedule) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public Class<? extends DoctorSchedule> getEntityClass() {
        return getClass();
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }
}
