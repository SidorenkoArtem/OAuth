package com.prototype.demo.model.requests;

import lombok.Data;

/**
 * Class for parse request user data.
 */
@Data
public class UserRequest {
    private String name;
    private String password;
    private String phone;
}
