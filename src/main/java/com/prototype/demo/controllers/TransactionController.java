package com.prototype.demo.controllers;

import com.prototype.demo.model.requests.TransactionRequest;
import com.prototype.demo.services.TransactionService;
import com.prototype.demo.services.impl.TransactionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController()
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<Object> getTransactionHistoryForUser(@PathVariable(name = "userId") Long userId) {
        return new ResponseEntity<>(transactionService.getUserTransactions(userId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Object> createTransaction(@RequestBody @Valid TransactionRequest transactionRequest) {
        return new ResponseEntity<>(transactionService.createTransaction(transactionRequest), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Object> findTransactionByQr(@RequestParam(name = "search") String search) {
        return new ResponseEntity<>(transactionService.findTransactionByQr(search), HttpStatus.OK);
    }
}
