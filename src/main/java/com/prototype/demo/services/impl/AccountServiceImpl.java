package com.prototype.demo.services.impl;

import com.prototype.demo.model.responses.AccountResponse;
import com.prototype.demo.repositories.AccountsRepository;
import com.prototype.demo.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountsRepository accountsRepository;

    @Override
    public AccountResponse getAccountByPhoneNumber(String phoneNumber) {
        //final
        return new AccountResponse();
    }
}
