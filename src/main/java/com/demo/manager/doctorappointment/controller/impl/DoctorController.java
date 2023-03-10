package com.demo.manager.doctorappointment.controller.impl;

import com.demo.manager.doctorappointment.controller.AbstractCrudController;
import com.demo.manager.doctorappointment.dto.impl.DoctorDto;
import com.demo.manager.doctorappointment.mapper.impl.DoctorMapper;
import com.demo.manager.doctorappointment.model.impl.Doctor;
import com.demo.manager.doctorappointment.repository.impl.DoctorRepository;
import com.demo.manager.doctorappointment.service.impl.DoctorService;
import com.demo.manager.doctorappointment.specification.filter.DoctorFilterParam;
import com.demo.manager.doctorappointment.util.OffsetLimitPageable;
import com.demo.manager.doctorappointment.util.resource.GeneralResource;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(GeneralResource.PATH + "/doctor")
public class DoctorController extends AbstractCrudController<Doctor, Long, DoctorDto, DoctorService, DoctorMapper, DoctorRepository> {

    public DoctorController(DoctorService doctorService) {
        super(doctorService);
    }

    @Override
    @GetMapping
    @Parameters({
            @Parameter(
                    name = "department_id",
                    in = ParameterIn.QUERY,
                    schema = @Schema(type = "integer")
            )
    })
    public ResponseEntity<List<DoctorDto>> findAll(HttpServletRequest httpServletRequest) {
        List<DoctorDto> doctors = service.findAllDoctors(DoctorFilterParam.of(httpServletRequest), OffsetLimitPageable.of(httpServletRequest));
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }
}
