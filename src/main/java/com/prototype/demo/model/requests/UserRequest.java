package com.prototype.demo.model.requests;

import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private String password;
    private String phone;
}
