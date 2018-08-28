package com.prototype.demo.services;

import com.prototype.demo.model.dao.User;
import com.prototype.demo.model.requests.TransactionRequest;
import com.prototype.demo.model.responses.TransactionResponse;
import com.prototype.demo.model.responses.TransactionsResponse;

public interface TransactionService {
    TransactionResponse findTransactionByQr(final String qrCode);
    TransactionResponse createTransaction(final TransactionRequest transactionRequest);
    TransactionsResponse getUserTransactions(final Long userId);
    void getTransactions(final TransactionsResponse transactionsResponse, final User user);
    void getTransactions(final TransactionResponse transactionsResponse, final User user);
}
