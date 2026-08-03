package com.lynkattu.shop.model;

import com.lynkattu.shop.enums.ItemCategory;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ItemModel(
        String id,
        String name,
        BigDecimal price,
        String description,
        ItemCategory itemCategory,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
