package com.prototype.demo.exeptions;

public class TransactionStatusNotExistsException extends ApplicationException {
    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.TRANSACTION_STATUS_NOT_EXIST;
    }
}