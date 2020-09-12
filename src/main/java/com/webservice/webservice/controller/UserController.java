package com.webservice.webservice.controller;

import com.webservice.webservice.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<User> findALL() {
        User user = new User(1, "Ragir", "ragirfernando@gmail.com", "999999999", "123456");
        return ResponseEntity.ok().body(user);
    }
}
