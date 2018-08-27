package com.prototype.demo.exeptions;

public class AccountNotExistsException extends ApplicationException {
    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.ACCOUNT_NOT_EXIST;
    }
}
