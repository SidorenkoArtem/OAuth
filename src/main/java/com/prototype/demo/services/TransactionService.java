package com.prototype.demo.services;

import com.prototype.demo.model.requests.TransactionRequest;
import com.prototype.demo.model.responses.TransactionResponse;

public interface TransactionService {
    TransactionResponse findTransactionByQr(final String qrCode);
    TransactionResponse createTransaction(final TransactionRequest transactionRequest);
}
