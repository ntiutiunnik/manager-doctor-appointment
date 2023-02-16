package com.demo.doctorappointmentmanager.service.impl;

import com.demo.doctorappointmentmanager.dto.impl.AccountDto;
import com.demo.doctorappointmentmanager.mapper.impl.AccountMapper;
import com.demo.doctorappointmentmanager.model.Account;
import com.demo.doctorappointmentmanager.repository.AccountRepository;
import com.demo.doctorappointmentmanager.service.AbstractService;
import jakarta.persistence.EntityManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class AccountService extends AbstractService<Account, Long, AccountDto, AccountMapper, AccountRepository> {
    public AccountService(AccountMapper accountMapper,
                          AccountRepository accountRepository,
                          EntityManager entityManager) {
        super(accountMapper, accountRepository, entityManager);
    }

    @Override
    protected void beforeSave(AccountDto accountDto) {
        String password = accountDto.getPassword();
        if (StringUtils.isEmpty(password)) {
            throw new IllegalArgumentException("Account password not provided.");
        }

        accountDto.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
    }
}
