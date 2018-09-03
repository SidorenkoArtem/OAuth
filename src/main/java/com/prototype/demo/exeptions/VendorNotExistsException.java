package com.prototype.demo.exeptions;

/**
 * Vendor does not exist exception class.
 */
public class VendorNotExistsException extends ApplicationException {
    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.VENDOR_NOT_EXIST;
    }
}
