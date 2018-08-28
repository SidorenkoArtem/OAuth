package com.prototype.demo.exeptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum  ErrorCode {
    ACCOUNT_NOT_EXIST(1, "Account does not exist"),
    TRANSACTION_STATUS_NOT_EXIST(2, "Transaction status does not exist"),
    USER_NOT_EXIST(3, "User does not exist"),
    VENDOR_NOT_EXIST(4, "Vendor does not exist"),
    TRANSACTION_NOT_EXIST(5, "Transaction does not exist");


    private final int errorCode;
    private final String message;
}
