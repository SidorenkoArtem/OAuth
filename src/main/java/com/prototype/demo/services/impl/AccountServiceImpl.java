package com.prototype.demo.services.impl;

import com.prototype.demo.exeptions.AccountNotExistsException;
import com.prototype.demo.exeptions.UserNotExistsException;
import com.prototype.demo.exeptions.VendorNotExistsException;
import com.prototype.demo.model.dao.Account;
import com.prototype.demo.model.dao.User;
import com.prototype.demo.model.dao.Vendor;
import com.prototype.demo.model.requests.AccountRequest;
import com.prototype.demo.model.responses.AccountResponse;
import com.prototype.demo.model.responses.TransactionsResponse;
import com.prototype.demo.repositories.AccountsRepository;
import com.prototype.demo.repositories.UsersRepository;
import com.prototype.demo.repositories.VendorsRepository;
import com.prototype.demo.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountsRepository accountsRepository;
    private final UsersRepository usersRepository;
    private final VendorsRepository vendorsRepository;

    @Override
    public AccountResponse getAccountByPhoneNumber(final String phoneNumber) {
        final AccountResponse accountResponse = new AccountResponse();
        final User user = usersRepository.findByPhoneEquals(phoneNumber).orElseThrow(UserNotExistsException::new);
        final Account account = accountsRepository.findByUser(user).orElseThrow(AccountNotExistsException::new);
        accountResponse.setAccount(account);
        return accountResponse;
    }

    @Override
    public AccountResponse createAccount(final AccountRequest accountRequest) {
        final AccountResponse accountResponse = new AccountResponse();
        final Account account = new Account();
        final User user = usersRepository.findById(accountRequest.getUserId()).orElseThrow(UserNotExistsException::new);
        final Vendor vendor = vendorsRepository.findById(accountRequest.getVendorId()).orElseThrow(VendorNotExistsException::new);

        account.setUser(user);
        account.setVendor(vendor);
        account.setAccountName(accountRequest.getAccountName());
        account.setAccountVendorNumber(accountRequest.getAccountVendorNumber());

        accountsRepository.save(account);

        accountResponse.setAccount(account);
        return accountResponse;
    }
}