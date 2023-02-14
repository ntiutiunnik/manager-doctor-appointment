package com.demo.doctorappointmentmanager.specification;

import com.demo.doctorappointmentmanager.model.Doctor;
import com.demo.doctorappointmentmanager.specification.filter.DoctorFilterParam;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class DoctorSpecification {
    public static Specification<Doctor> getFilteredDoctors(DoctorFilterParam params) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            Long departmentId = params.getDepartmentId();
            if (departmentId != null) {
                predicates.add(criteriaBuilder.equal(root.get("department").<Long> get("id"), departmentId));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}