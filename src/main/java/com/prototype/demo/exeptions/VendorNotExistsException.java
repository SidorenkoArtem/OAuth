package com.prototype.demo.exeptions;

public class VendorNotExistsException extends ApplicationException {
    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.VENDOR_NOT_EXIST;
    }
}
