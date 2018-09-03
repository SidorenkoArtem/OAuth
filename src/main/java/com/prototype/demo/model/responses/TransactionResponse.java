package com.prototype.demo.model.responses;

import com.prototype.demo.model.dao.Transaction;
import lombok.Data;

/**
 * Class for transfer response transaction data.
 */
@Data
public class TransactionResponse {
    private Transaction transaction;
}
