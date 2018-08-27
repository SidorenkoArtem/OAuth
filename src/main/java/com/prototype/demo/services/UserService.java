package com.prototype.demo.services;

import com.prototype.demo.model.dao.User;

import java.util.List;

public interface UserService {
    User save(User user);
    List<User> findAll();
    void delete(long id);
}
