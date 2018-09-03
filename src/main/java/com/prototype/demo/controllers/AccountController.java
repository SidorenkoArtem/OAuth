package com.prototype.demo.controllers;

import com.prototype.demo.model.requests.AccountRequest;
import com.prototype.demo.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * Account controller.
 * This controller for working with account data.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    /**
     * Inject: AccountService through constructor.
     */
    private final AccountService accountService;

    /**
     * URL : "/account"
     * Search account by phone number.
     */
    @GetMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> getAccountByPhoneNumber(@RequestParam(name = "phoneNumber") String phoneNumber) {
        return new ResponseEntity<>(accountService.getAccountByPhoneNumber(phoneNumber), HttpStatus.OK);
    }

    /**
     * URL : "/account"
     * Method create account.
     */
    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> createAccount(@RequestBody AccountRequest accountRequest) {
        return new ResponseEntity<>(accountService.createAccount(accountRequest), HttpStatus.OK);
    }
}
