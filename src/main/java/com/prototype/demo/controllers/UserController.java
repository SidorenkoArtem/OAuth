package com.prototype.demo.controllers;

import com.prototype.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Transaction controller.
 * This controller for working with user.
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    final UserService userService;

    /**
     * Method for creating user.
     * @return
     */
    public ResponseEntity<Object> createUser() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
