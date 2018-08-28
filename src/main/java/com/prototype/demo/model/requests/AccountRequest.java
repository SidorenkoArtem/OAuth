package com.prototype.demo.model.requests;

import lombok.Data;

@Data
public class AccountRequest {
    private final String accountName;
    private final String accountVendorNumber;
    private final Long userId;
    private final Long vendorId;
}
