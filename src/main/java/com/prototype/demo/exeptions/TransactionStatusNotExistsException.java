package com.prototype.demo.exeptions;

/**
 * Transaction Status does not exist exception class.
 */
public class TransactionStatusNotExistsException extends ApplicationException {
    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.TRANSACTION_STATUS_NOT_EXIST;
    }
}