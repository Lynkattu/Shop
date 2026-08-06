package com.lynkattu.shop.service;

import com.lynkattu.shop.model.UserRequest;
import com.lynkattu.shop.model.UserResponse;
import com.lynkattu.shop.repository.UserRepository;

import java.util.Optional;

public class UserService {
    private final UserRepository repository;
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Optional<UserResponse> createUser(UserRequest userRequest) {
        return repository.createUser(userRequest);
    }
}
