package com.prototype.demo.model.requests;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Class for parse request transaction data.
 */
@Data
public class TransactionRequest {
    private Integer counterPartyAccountId;
    private String transactionCurrency;
    private LocalDateTime transactionDate;
    private String transactionQrString;
    private String transactionSubject;
    private Long accountId;
    private Long transactionStatusId;
}
