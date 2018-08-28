package com.prototype.demo.services;

import com.prototype.demo.model.requests.AccountRequest;
import com.prototype.demo.model.responses.AccountResponse;

public interface AccountService {

    AccountResponse getAccountByPhoneNumber(final String phoneNumber);
    AccountResponse createAccount(final AccountRequest accountRequest);
}