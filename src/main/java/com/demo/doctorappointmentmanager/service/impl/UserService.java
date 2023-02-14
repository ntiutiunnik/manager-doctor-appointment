package com.demo.doctorappointmentmanager.service.impl;

import com.demo.doctorappointmentmanager.dto.UserDto;
import com.demo.doctorappointmentmanager.mapper.UserMapper;
import com.demo.doctorappointmentmanager.model.User;
import com.demo.doctorappointmentmanager.repository.UserRepository;
import com.demo.doctorappointmentmanager.service.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserService extends AbstractService<User, Long, UserDto, UserMapper, UserRepository> {
    public UserService(UserMapper userMapper, UserRepository userRepository) {
        super(userMapper, userRepository);
    }

    @Override
    public UserDto save(UserDto userDto) {
        User user = mapper.dtoToEntity(userDto);
        String password = user.getPassword();

        if (StringUtils.isEmpty(password)) {
            throw new IllegalArgumentException("User password not provided.");
        }

        password = DigestUtils.md5DigestAsHex(password.getBytes());

        return mapper.entityToDto(repository.save(user));
    }
}
