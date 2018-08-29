package com.prototype.demo.services;

import com.prototype.demo.model.dao.User;
import com.prototype.demo.model.requests.UserRequest;
import com.prototype.demo.model.responses.UserResponse;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    User save(User user);
    List<User> findAll();
    void delete(long id);
    UserResponse createUser(final UserRequest userRequest);
    UserDetails loadUserByUsername(String userId);
}
