package com.demo.manager.doctorappointment.service.impl;

import com.demo.manager.doctorappointment.dto.impl.AccountDto;
import com.demo.manager.doctorappointment.mapper.impl.AccountMapper;
import com.demo.manager.doctorappointment.model.impl.Account;
import com.demo.manager.doctorappointment.repository.impl.AccountRepository;
import com.demo.tools.doctorappointment.autoconfigure.exception.CustomCrudException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class AccountService extends PagingCrudServiceImpl<AccountDto, Long, Account, AccountMapper, AccountRepository> {

    private static final int MINIMUM_LENGTH = 5;

    public AccountService(AccountMapper accountMapper,
                          AccountRepository accountRepository,
                          ObjectMapper objectMapper) {
        super(accountMapper, accountRepository, objectMapper);
    }

    @Override
    protected void beforeSave(AccountDto accountDto) {
        String login = accountDto.getLogin();
        if (!isValid(login)) {
            throw new CustomCrudException("Account login should be minimum " + MINIMUM_LENGTH + " symbols long.");
        }

        String password = accountDto.getPassword();
        if (!isValid(password)) {
            throw new CustomCrudException("Account password should be minimum " + MINIMUM_LENGTH + " symbols long.");
        }

        accountDto.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
    }

    private boolean isValid(String input) {
        return input != null && input.length() > MINIMUM_LENGTH;
    }
}
