package com.lynkattu.shop.model;

import com.lynkattu.shop.enums.ItemCategory;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ItemRequest(
        @NotBlank
        String name,
        @DecimalMin("0.00")
        @Digits(integer = 6, fraction = 2)
        BigDecimal price,
        @NotBlank
        String description,
        ItemCategory itemCategory
) {}
