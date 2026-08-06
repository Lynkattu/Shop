package com.lynkattu.shop.model;

import com.lynkattu.shop.enums.Country;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(
        @NotBlank
        String firstname,
        @NotBlank
        String lastname,
        @Email
        String email,
        String phone,
        @NotBlank
        String address,
        @NotBlank
        String postalcode,
        @NotBlank
        String city,
        Country country,
        @NotBlank
        String username,
        @NotBlank
        String password
) {}
