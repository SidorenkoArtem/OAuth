package com.prototype.demo.model.responses;

import com.prototype.demo.model.dao.Transaction;
import lombok.Data;

import java.util.List;

/**
 * Class for transfer response transaction data.
 */
@Data
public class TransactionsResponse {
    private List<Transaction> transactions;
}
