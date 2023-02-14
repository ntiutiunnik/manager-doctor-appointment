package com.demo.doctorappointmentmanager.controller.impl;

import com.demo.doctorappointmentmanager.controller.AbstractCrudController;
import com.demo.doctorappointmentmanager.dto.UserDto;
import com.demo.doctorappointmentmanager.mapper.UserMapper;
import com.demo.doctorappointmentmanager.model.User;
import com.demo.doctorappointmentmanager.repository.UserRepository;
import com.demo.doctorappointmentmanager.service.impl.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends AbstractCrudController<User, Long, UserDto, UserService, UserMapper, UserRepository> {

    public UserController(UserService userService) {
        super(userService);
    }
}
