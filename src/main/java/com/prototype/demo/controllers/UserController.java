package com.prototype.demo.controllers;

import com.prototype.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    final UserService userService;

    public ResponseEntity<Object> createUser() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
