package com.prototype.demo.model.responses;

import com.prototype.demo.model.dao.Account;
import lombok.Data;

/**
 * Class for transfer response account data.
 */
@Data
public class AccountResponse {
    private Account account;
}
