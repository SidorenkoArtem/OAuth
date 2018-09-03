package com.prototype.demo.model.responses;

import com.prototype.demo.model.dao.User;
import lombok.Data;

/**
 * Class for transfer response user data.
 */
@Data
public class UserResponse {
    private User user;
}
