package com.prototype.demo.exeptions;

public class UserNotExistsException extends ApplicationException {
    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.USER_NOT_EXIST;
    }
}
