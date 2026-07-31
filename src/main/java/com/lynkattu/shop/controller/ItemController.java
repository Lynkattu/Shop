package com.lynkattu.shop.controller;

import com.lynkattu.shop.model.ItemModel;
import com.lynkattu.shop.model.ItemRequest;
import com.lynkattu.shop.repository.ItemRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    private final ItemRepository repository;

    public ItemController(ItemRepository repository) {
        this.repository = repository;
    }
    private Optional<ItemModel> item;

    @GetMapping("")
    public ResponseEntity<?> getAllItems() {

        List<ItemModel> items = repository.findAllItems();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getItemById(@PathVariable String id) {
        Optional<ItemModel> item = repository.findItemById(id);

        if (item.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found");
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(item);


    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("")
    public ResponseEntity<?> addItem(@Valid @RequestBody ItemRequest itemRequest) {
        Optional<ItemModel> item = repository.createItem(itemRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Item Created successfully");
    }


}
