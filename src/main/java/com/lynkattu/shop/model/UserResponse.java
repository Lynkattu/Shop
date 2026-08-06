package com.lynkattu.shop.model;

import com.lynkattu.shop.enums.Country;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record UserResponse(
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
        String membershipNumber,
        BigDecimal balance,
        List<PurchaseOrderModel> purchaseHistory,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
