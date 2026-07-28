package com.lynkattu.shop.controller;

import com.lynkattu.shop.model.ItemModel;
import com.lynkattu.shop.repository.ItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    private final ItemRepository repository;

    public ItemController(ItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllItems() {

        List<ItemModel> items = repository.findAllItems();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getItemById(@PathVariable String id) {
        ItemModel item = repository.findItemById(id);

        if (Objects.equals(item.id(), id)) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(item);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found");
        }

    }

    @PostMapping("")
    public ResponseEntity<?> addItem() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Item Created successfully");
    }


}
