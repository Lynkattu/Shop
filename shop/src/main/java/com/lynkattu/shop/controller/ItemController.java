package com.lynkattu.shop.controller;

import com.lynkattu.shop.model.ItemModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    @GetMapping("")
    public List<ItemModel> getAllItems() {
        List<ItemModel> items = Collections.<ItemModel>emptyList();
        return items;
    }

}
