package com.demo.manager.doctorappointment.specification.impl;

import com.demo.manager.doctorappointment.model.impl.Appointment;
import com.demo.manager.doctorappointment.specification.SpecificationUtils;
import com.demo.manager.doctorappointment.specification.filter.impl.AppointmentFilterParam;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class AppointmentSpecificationUtils implements SpecificationUtils<Appointment, AppointmentFilterParam> {

    public Specification<Appointment> createSpecification(AppointmentFilterParam params) {
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