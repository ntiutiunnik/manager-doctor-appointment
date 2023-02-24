package com.demo.manager.doctorappointment.controller.impl;

import com.demo.manager.doctorappointment.controller.AbstractCrudController;
import com.demo.manager.doctorappointment.dto.impl.DoctorScheduleDto;
import com.demo.manager.doctorappointment.mapper.impl.DoctorScheduleMapper;
import com.demo.manager.doctorappointment.model.impl.DoctorSchedule;
import com.demo.manager.doctorappointment.repository.impl.DoctorScheduleRepository;
import com.demo.manager.doctorappointment.service.impl.DoctorScheduleService;
import com.demo.manager.doctorappointment.specification.filter.DoctorScheduleFilterParam;
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
@RequestMapping(GeneralResource.PATH + "/doctor_schedule")
public class DoctorScheduleController extends AbstractCrudController<DoctorSchedule, Long, DoctorScheduleDto, DoctorScheduleService, DoctorScheduleMapper, DoctorScheduleRepository> {

    public DoctorScheduleController(DoctorScheduleService doctorScheduleService) {
        super(doctorScheduleService);
    }

    @Override
    @GetMapping
    @Parameters({
            @Parameter(
                    name = "doctor_id",
                    in = ParameterIn.QUERY,
                    schema = @Schema(type = "integer", example = "1")
            ),
            @Parameter(
                    name = "time_slot_id",
                    in = ParameterIn.QUERY,
                    schema = @Schema(type = "integer", example = "1")
            )
    })
    public ResponseEntity<List<DoctorScheduleDto>> findAll(HttpServletRequest httpServletRequest) {
        List<DoctorScheduleDto> doctorScheduleDtos = service.findAllDoctorSchedules(DoctorScheduleFilterParam.of(httpServletRequest), OffsetLimitPageable.of(httpServletRequest));
        return new ResponseEntity<>(doctorScheduleDtos, HttpStatus.OK);
    }
}
