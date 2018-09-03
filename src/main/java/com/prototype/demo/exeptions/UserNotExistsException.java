package com.prototype.demo.exeptions;

/**
 * User does not exist exception class.
 */
public class UserNotExistsException extends ApplicationException {
    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.USER_NOT_EXIST;
    }
}
