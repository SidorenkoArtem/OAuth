package com.prototype.demo.exeptions;

public class TransactionNotExistsException extends ApplicationException {
    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.TRANSACTION_NOT_EXIST;
    }
}
