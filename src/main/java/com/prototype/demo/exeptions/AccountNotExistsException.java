package com.prototype.demo.exeptions;

/**
 * Account does not exist exception class.
 */
public class AccountNotExistsException extends ApplicationException {
    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.ACCOUNT_NOT_EXIST;
    }
}
