package com.demo.manager.doctorappointment.controller.impl;

import com.demo.manager.doctorappointment.controller.AbstractCrudController;
import com.demo.manager.doctorappointment.dto.impl.AccountDto;
import com.demo.manager.doctorappointment.mapper.impl.AccountMapper;
import com.demo.manager.doctorappointment.model.impl.Account;
import com.demo.manager.doctorappointment.repository.impl.AccountRepository;
import com.demo.manager.doctorappointment.service.impl.AccountService;
import com.demo.manager.doctorappointment.util.resource.GeneralResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GeneralResource.PATH + "/account")
public class AccountController extends AbstractCrudController<Account, Long, AccountDto, AccountService, AccountMapper, AccountRepository> {

    public AccountController(AccountService accountService) {
        super(accountService);
    }
}
