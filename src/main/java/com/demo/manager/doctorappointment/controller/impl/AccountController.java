package com.demo.manager.doctorappointment.controller.impl;

import com.demo.manager.doctorappointment.dto.impl.AccountDto;
import com.demo.manager.doctorappointment.service.impl.AccountService;
import com.demo.manager.doctorappointment.resource.GeneralResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GeneralResource.PATH + "/account")
public class AccountController extends PagingCrudControllerImpl<AccountDto, Long> {

    protected AccountController(AccountService accountService) {
        super(accountService);
    }
}
