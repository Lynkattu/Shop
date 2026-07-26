package com.lynkattu.shop.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ItemModel(
        String id,
        String name,
        BigDecimal price,
        String description,
        String itemCategory,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

}
