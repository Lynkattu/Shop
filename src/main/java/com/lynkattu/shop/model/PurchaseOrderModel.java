package com.lynkattu.shop.model;

import com.lynkattu.shop.enums.OrderStatus;
import com.lynkattu.shop.enums.PaymentStatus;

import java.time.LocalDateTime;
import java.util.List;

public record PurchaseOrderModel(
        String id,
        List<ItemModel> purchase,
        OrderStatus orderStatus,
        PaymentStatus paymentStatus,
        List<ItemModel> refunded,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
