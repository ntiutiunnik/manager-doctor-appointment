package com.demo.manager.doctorappointment.service.impl;

import com.demo.manager.doctorappointment.dto.impl.AccountDto;
import com.demo.manager.doctorappointment.mapper.impl.AccountMapper;
import com.demo.manager.doctorappointment.model.impl.Account;
import com.demo.manager.doctorappointment.repository.impl.AccountRepository;
import com.demo.manager.doctorappointment.service.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class AccountService extends AbstractService<Account, Long, AccountDto, AccountMapper, AccountRepository> {
    public AccountService(AccountMapper accountMapper,
                          AccountRepository accountRepository) {
        super(accountMapper, accountRepository);
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
