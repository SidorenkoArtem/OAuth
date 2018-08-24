package com.prototype.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class hello {

    @GetMapping
    public ResponseEntity<String> test() {
        System.out.println("Hello");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
