package com.prototype.demo.model.responses;

import com.prototype.demo.model.dao.Transaction;
import lombok.Data;

@Data
public class TransactionResponse {
    private Transaction transaction;
}
