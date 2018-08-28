package com.prototype.demo.controllers;

import com.prototype.demo.model.requests.AccountRequest;
import com.prototype.demo.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping()
    public ResponseEntity<Object> getAccountByPhoneNumber(@RequestParam(name = "phoneNumber") String phoneNumber) {
        return new ResponseEntity<>(accountService.getAccountByPhoneNumber(phoneNumber), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Object> createAccount(@RequestBody AccountRequest accountRequest) {
        return new ResponseEntity<>(accountService.createAccount(accountRequest), HttpStatus.OK);
    }
}
