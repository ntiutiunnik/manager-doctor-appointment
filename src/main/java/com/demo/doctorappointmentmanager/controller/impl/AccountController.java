package com.demo.doctorappointmentmanager.controller.impl;

import com.demo.doctorappointmentmanager.controller.AbstractCrudController;
import com.demo.doctorappointmentmanager.dto.impl.AccountDto;
import com.demo.doctorappointmentmanager.mapper.impl.AccountMapper;
import com.demo.doctorappointmentmanager.model.Account;
import com.demo.doctorappointmentmanager.repository.AccountRepository;
import com.demo.doctorappointmentmanager.service.impl.AccountService;
import com.demo.doctorappointmentmanager.util.resource.GeneralResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GeneralResource.PATH + "/account")
public class AccountController extends AbstractCrudController<Account, Long, AccountDto, AccountService, AccountMapper, AccountRepository> {

    public AccountController(AccountService accountService) {
        super(accountService);
    }
}
