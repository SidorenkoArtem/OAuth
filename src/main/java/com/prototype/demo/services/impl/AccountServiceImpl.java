package com.prototype.demo.services.impl;

import com.prototype.demo.exeptions.AccountNotExistsException;
import com.prototype.demo.exeptions.UserNotExistsException;
import com.prototype.demo.model.dao.Account;
import com.prototype.demo.model.dao.User;
import com.prototype.demo.model.responses.AccountResponse;
import com.prototype.demo.repositories.AccountsRepository;
import com.prototype.demo.repositories.UsersRepository;
import com.prototype.demo.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountsRepository accountsRepository;
    private final UsersRepository usersRepository;

    @Override
    public AccountResponse getAccountByPhoneNumber(String phoneNumber) {
        final AccountResponse accountResponse = new AccountResponse();
        final User user = usersRepository.findByPhoneEquals(phoneNumber).orElseThrow(UserNotExistsException::new);
        final Account account = accountsRepository.findByUser(user).orElseThrow(AccountNotExistsException::new);
        accountResponse.setAccount(account);
        return accountResponse;
    }
}
