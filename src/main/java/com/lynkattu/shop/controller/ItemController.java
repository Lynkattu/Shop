package com.lynkattu.shop.controller;

import com.lynkattu.shop.model.ItemModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    @GetMapping("")
    public ResponseEntity<?> getAllItems() {
        List<ItemModel> items = Collections.<ItemModel>emptyList();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getItemById(@PathVariable String id) {
        ItemModel item = new ItemModel(
                "12345",
                "test item",
                BigDecimal.valueOf(12.99),
                "Random item.",
                null,
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        if (Objects.equals(item.id(), id)) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(item);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Item not found");
    }

    @GetMapping("")
    public ResponseEntity<?> addItem() {
        return new ResponseEntity<>("Item Created successfully", HttpStatus.CREATED);
    }


}
