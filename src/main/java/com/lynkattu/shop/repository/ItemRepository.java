package com.lynkattu.shop.repository;

import com.lynkattu.shop.model.ItemModel;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Repository
public class ItemRepository {

    public List<ItemModel> findAllItems() {
        List<ItemModel> items = Collections.<ItemModel>emptyList();
        return items;
    }

    public ItemModel findItemById(String id) {
        ItemModel item = new ItemModel(
                "12345",
                "test item",
                BigDecimal.valueOf(12.99),
                "Random item.",
                null,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        return item;
    }

}
