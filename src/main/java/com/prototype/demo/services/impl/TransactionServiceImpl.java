package com.prototype.demo.services.impl;

import com.prototype.demo.exeptions.AccountNotExistsException;
import com.prototype.demo.exeptions.TransactionStatusNotExistsException;
import com.prototype.demo.model.dao.Account;
import com.prototype.demo.model.dao.Transaction;
import com.prototype.demo.model.dao.TransactionStatus;
import com.prototype.demo.model.requests.TransactionRequest;
import com.prototype.demo.model.responses.TransactionResponse;
import com.prototype.demo.repositories.AccountsRepository;
import com.prototype.demo.repositories.TransactionStatusRepository;
import com.prototype.demo.repositories.TransactionsRepository;
import com.prototype.demo.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionsRepository transactionsRepository;
    private final AccountsRepository accountsRepository;
    private final TransactionStatusRepository transactionStatusRepository;

    @Override
    @Transactional(readOnly = true)
    public TransactionResponse findTransactionByQr(final String qrCode) {
        final TransactionResponse transaction = new TransactionResponse();
        transaction.setTransaction(transactionsRepository.findByTransactionQrStringEquals(qrCode).orElse(null));
        return transaction;
    }

    @Override
    @Transactional
    public TransactionResponse createTransaction(TransactionRequest transactionRequest) {
        final Transaction transaction = new Transaction();
        final Account account = accountsRepository.findById(transactionRequest.getAccountId())
                .orElseThrow(AccountNotExistsException::new);
        final TransactionStatus transactionStatus = transactionStatusRepository.findById(transactionRequest.getTransactionStatusId())
                .orElseThrow(TransactionStatusNotExistsException::new);

        transaction.setAccount(account);
        transaction.setTransactionStatus(transactionStatus);
        transaction.setCounterPartyAccountId(transactionRequest.getCounterPartyAccountId());
        transaction.setTransactionAmount(transactionRequest.getCounterPartyAccountId());
        transaction.setTransactionCurrency(transactionRequest.getTransactionCurrency());
        transaction.setTransactionSubject(transactionRequest.getTransactionSubject());
        transaction.setTransactionDate(transactionRequest.getTransactionDate());
        transaction.setTransactionQrString(transactionRequest.getTransactionQrString());

        final TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setTransaction(transaction);
        return transactionResponse;
    }

}
