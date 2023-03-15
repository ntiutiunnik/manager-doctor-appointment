package com.demo.manager.doctorappointment.specification.impl;

import com.demo.manager.doctorappointment.model.impl.Doctor;
import com.demo.manager.doctorappointment.specification.SpecificationUtils;
import com.demo.manager.doctorappointment.specification.filter.impl.DoctorFilterParam;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorSpecificationUtils implements SpecificationUtils<Doctor, DoctorFilterParam> {

    @Override
    public Specification<Doctor> createSpecification(DoctorFilterParam params) {
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