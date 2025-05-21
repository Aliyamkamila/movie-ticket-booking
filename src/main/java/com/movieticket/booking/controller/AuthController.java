package com.movieticket.booking.controller;

import com.movieticket.booking.model.User;
import com.movieticket.booking.dto.LoginDTO;
import com.movieticket.booking.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User registeredUser = userService.register(user);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginDTO login) {
        User user = userService.login(login.getUsername(), login.getPassword());
        return ResponseEntity.ok(user);
    }
}
