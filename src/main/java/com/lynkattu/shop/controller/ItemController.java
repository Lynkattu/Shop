package com.lynkattu.shop.controller;

import com.lynkattu.shop.model.ItemModel;
import com.lynkattu.shop.model.ItemRequest;
import com.lynkattu.shop.repository.ItemRepository;
import com.lynkattu.shop.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllItems() {

        List<ItemModel> items = service.findAllItems();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getItemById(@PathVariable String id) {
        Optional<ItemModel> item = service.findItemById(id);

        if (item.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found");
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(item);
    }

    @PostMapping("")
    public ResponseEntity<ItemModel> addItem(@Valid @RequestBody ItemRequest itemRequest) {
        ItemModel createdItem = service.createItem(itemRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdItem);
    }


}
