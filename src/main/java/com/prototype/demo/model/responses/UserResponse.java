package com.prototype.demo.model.responses;

import com.prototype.demo.model.dao.User;
import lombok.Data;

@Data
public class UserResponse {
    private User user;
}
