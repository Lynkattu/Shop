package com.lynkattu.shop.controller;

import com.lynkattu.shop.model.UserRequest;
import com.lynkattu.shop.model.UserResponse;
import com.lynkattu.shop.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    final private UserService service;
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("")
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest userRequest) {
        Optional<UserResponse> createdUser = service.createUser(userRequest);
        if (createdUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to create a user");
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdUser.get());
    }
}
