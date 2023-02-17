package com.demo.manager.doctorappointment.specification;

import com.demo.manager.doctorappointment.model.impl.Appointment;
import com.demo.manager.doctorappointment.specification.filter.AppointmentFilterParam;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class AppointmentSpecification {
    public static Specification<Appointment> getFilteredAppointments(AppointmentFilterParam params) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            Long accountId = params.getAccountId();
            if (accountId != null) {
                predicates.add(criteriaBuilder.equal(root.get("account").<Long> get("id"), accountId));
            }

            Long doctorId = params.getDoctorId();
            if (doctorId != null) {
                predicates.add(criteriaBuilder.equal(root.get("doctorSchedule").get("doctor").<Long> get("id"), doctorId));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}