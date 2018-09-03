package com.prototype.demo.exeptions;

/**
 * Transaction does not exist exception class.
 */
public class TransactionNotExistsException extends ApplicationException {
    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.TRANSACTION_NOT_EXIST;
    }
}
