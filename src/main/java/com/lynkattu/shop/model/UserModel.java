package com.lynkattu.shop.model;

import com.lynkattu.shop.enums.Country;

import java.math.BigDecimal;

public record UserModel (
        String id,
        String firstname,
        String lastname,
        String email,
        String phone,
        String address,
        String postalcode,
        String city,
        Country country,
        String username,
        String password,
        String membershipNumber,
        BigDecimal balance
) {}
